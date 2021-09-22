package com.mapsa.orm.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {

    String url;
    String username;
    String password;
    String driverName;

    private DBConnection() {
    }

    private static DBConnection dbConnection = null;
    private Connection connection;

    public Connection getConnection() throws IOException {
        InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(input);
        url = properties.getProperty("db.url");
        username = properties.getProperty("db.username");
        password = properties.getProperty("db.password");
        driverName = properties.getProperty("db.driverName");

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DBConnection getInstance(){
        if(dbConnection == null) {
            synchronized (DBConnection.class) {
                dbConnection = new DBConnection();
            }
        }
        return dbConnection;
    }
}
