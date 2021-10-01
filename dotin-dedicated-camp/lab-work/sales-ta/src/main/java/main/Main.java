package main;

import sales.product.Product;
import sales.product.service.impl.ProductServiceImpl;
import sales.user.User;
import sales.user.service.impl.UserServiceImpl;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        ProductServiceImpl productService = ProductServiceImpl.getInstance();
        UserServiceImpl userService = UserServiceImpl.getInstance();
        restart:
        System.out.println("Welcome to Sales!");
        boolean breaking = true;
        while (breaking) {
            System.out.println("Please login \n");
            System.out.println("username: ");
            String username = scanner.next();
            System.out.println("password: ");
            String password = scanner.next();
            Set<User> all = userService.getAll();
            Product product = productService.getAll().stream().findFirst().orElse(null);
            User user1 = all.stream()
                    .filter(user -> user.getUsername().equals(username))
                    .findAny()
                    .orElse(null);
            if (user1 != null) {
                if (user1.getPassword().equals(password)) {
                    if (username.equals("admin")) {
                        System.out.println("Welcome Sir ------------");
                        if (product == null) {
                            System.out.println("You need to add at least one product");
                            System.out.println("product name:");
                            String name = scanner.next();
                            System.out.println("product base price:");
                            long price = scanner.nextLong();
                            Product newProduct = new Product.Builder().name(name).basePrice(price).build();
                            productService.saveProduct(newProduct);
                            System.out.println("product saved");
                        }
                        System.out.println("please select one of your options:");
                        System.out.println("1) close the current sale, 2) update your product 3) exit");
                        input = scanner.nextInt();
                        switch (input) {
                            case 1: {
                                User highestSuggestion = userService.getHighestSuggestion();
                                if (highestSuggestion != null) {
                                    System.out.println("User " +
                                            "name : " + highestSuggestion.getUsername() + " " +
                                            "suggested price: " + highestSuggestion.getSuggestedPrice());
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("your current product is : " +
                                        "name: " + product.getName() + ", " +
                                        "base price: " + product.getBasePrice());
                                System.out.println("enter your desired name : ");
                                String desiredName = scanner.next();
                                System.out.println("enter your desired price : ");
                                long desiredPrice = scanner.nextLong();
                                Product updatedProduct = new Product.Builder()
                                        .id(product.getId())
                                        .name(desiredName)
                                        .basePrice(desiredPrice)
                                        .build();
                                productService.updateProduct(updatedProduct);
                                System.out.println("product updated successfully!");
                                System.out.println("your updated product is : " +
                                        "name: " + updatedProduct.getName() + ", " +
                                        "base price: " + updatedProduct.getBasePrice());
                                break;
                            }
                            case 3 :
                                breaking = false;
                            default:
                                break;
                        }
                    } else {
                        if (product != null) {
                            System.out.println("please select one of your options:");
                            System.out.println("1) set your suggesting price, 2) update your profile 3) exit");
                            input = scanner.nextInt();
                            switch (input) {
                                case 1: {
                                    System.out.println("your current suggestion is : " +
                                            "price: " + user1.getSuggestedPrice());
                                    System.out.println("enter your desired price : (the base price for this " +
                                            "product is: " + product.getBasePrice() + ")");
                                    long desiredPrice = scanner.nextLong();
                                    if (desiredPrice >= product.getBasePrice()) {
                                        User setSuggestion = new User.Builder()
                                                .id(user1.getId())
                                                .username(user1.getUsername())
                                                .password(user1.getPassword())
                                                .suggestedPrice(desiredPrice)
                                                .build();
                                        userService.updateUser(setSuggestion);
                                        System.out.println("User " +
                                                "name : " + setSuggestion.getUsername() + " " +
                                                "suggested price: " + setSuggestion.getSuggestedPrice());
                                        break;
                                    } else {
                                        System.err.println("you should not enter less than base price!");
                                        break;
                                    }
                                }
                                case 2: {
                                    System.out.println("your current product is : " +
                                            "name: " + product.getName() + ", " +
                                            "base price: " + product.getBasePrice());
                                    System.out.println("enter your desired username : ");
                                    String desiredName = scanner.next();
                                    System.out.println("enter your desired password : ");
                                    String desiredpassword = scanner.next();
                                    System.out.println("enter your desired price : ");
                                    long desiredPrice = scanner.nextLong();
                                    User updatedUser = new User.Builder()
                                            .id(user1.getId())
                                            .username(desiredName)
                                            .password(desiredpassword)
                                            .suggestedPrice(desiredPrice)
                                            .build();
                                    userService.updateUser(updatedUser);
                                    System.out.println("user updated successfully!");
                                    System.out.println("your updated profile is : " +
                                            "name: " + updatedUser.getUsername() + ", " +
                                            "base price: " + updatedUser.getSuggestedPrice());
                                    break;
                                }
                                case 3:
                                    breaking = false;
                                default:
                                    break;
                            }
                        } else {
                            System.err.println("no sales are available right now");
                        }
                    }
                }
            } else {
                System.err.println("User Not Found, Wanna create one?");
                System.out.println("1) yes  2) no");
                input = scanner.nextInt();
                switch (input) {
                    case 1:
                        userService.saveUser(new User.Builder().username(username).password(password).build());
                        break;
                    case 2:
                        System.out.println("ok");
                        break;
                }
            }
        }
    }
}
