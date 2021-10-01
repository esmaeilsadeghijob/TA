package sales.product.service.impl;

import dbconncetion.impl.DatabaseServiceImpl;
import dbconncetion.impl.TableName;
import sales.product.Product;
import sales.product.service.ProductService;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class ProductServiceImpl implements ProductService {
    DatabaseServiceImpl databaseService = DatabaseServiceImpl.getInstance();

    // making our service threadsafe and also singleton
    private static ProductServiceImpl instance;

    private ProductServiceImpl() {
    }

    // Using double checking
    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            synchronized (ProductServiceImpl.class) {
                if (instance == null) {
                    instance = new ProductServiceImpl();
                }
            }
        }
        return instance;
    }


    @Override
    public void saveProduct(Product product) {
        String values = product.getId() + ",\'" + product.getName() + "\'," + product.getBasePrice();
        try {
            databaseService.openConnection();
            databaseService.saveData(TableName.Product, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            databaseService.openConnection();
            databaseService.updateData(TableName.Product,
                    product.getName(),
                    null ,
                    product.getBasePrice(),
                    product.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Product> getAll() {
        Set<Product> products = new HashSet<>();
        try {
            databaseService.openConnection();
            ResultSet rs = databaseService.getAll(TableName.Product, null);
            while (rs.next()){
                products.add(new Product.Builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .basePrice(rs.getLong("base_price"))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
