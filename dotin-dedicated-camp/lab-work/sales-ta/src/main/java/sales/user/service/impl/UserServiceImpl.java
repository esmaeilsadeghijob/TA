package sales.user.service.impl;

import dbconncetion.impl.DatabaseServiceImpl;
import dbconncetion.impl.TableName;
import sales.product.Product;
import sales.product.service.impl.ProductServiceImpl;
import sales.user.User;
import sales.user.service.UserService;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class UserServiceImpl implements UserService {
    // making our service threadsafe and also singleton
    private static UserServiceImpl instance;
    DatabaseServiceImpl databaseService = DatabaseServiceImpl.getInstance();

    private UserServiceImpl() {
    }

    // Using double checking
    public static UserServiceImpl getInstance() {
        if (instance == null) {
            synchronized (UserServiceImpl.class) {
                if (instance == null) {
                    instance = new UserServiceImpl();
                }
            }
        }
        return instance;
    }


    @Override
    public void saveUser(User user) {
        String values = user.getId() + ",\'" + user.getUsername() + "\'," + "\'" + user.getPassword() + "\'," + user.getSuggestedPrice();
        try {
            databaseService.openConnection();
            databaseService.saveData(TableName.User, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            databaseService.openConnection();
            databaseService.updateData(TableName.User,
                    user.getUsername(),
                    user.getPassword(),
                    user.getSuggestedPrice(),
                    user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<User> getAll() {
        Set<User> users = new HashSet<>();
        try {
            databaseService.openConnection();
            ResultSet rs = databaseService.getAll(TableName.User, null);
            while (rs.next()) {
                users.add(new User.Builder()
                        .id(rs.getLong("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .suggestedPrice(rs.getLong("suggested_price"))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getHighestSuggestion() {
        Set<User> all = getAll();
        Product product = ProductServiceImpl.getInstance().getAll().stream().findFirst().orElse(null);
        if (product != null) {
            User highest = null;
            long checkPrice = product.getBasePrice();
            for (User user : all) {
                if (user.getSuggestedPrice() > checkPrice) {
                    highest = new User.Builder()
                            .username(user.getUsername())
                            .suggestedPrice(user.getSuggestedPrice())
                            .id(user.getId())
                            .build();
                    checkPrice = user.getSuggestedPrice();
                }
            }

            if (highest != null) {
                return highest;
            } else {
                System.err.println("no high bid found!");
            }
        } else {
            System.err.println("no product available!");
        }
        return null;
    }
}
