package com.mapsa.phoneBook.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionToDB {
    private static ConnectionToDB connectionToDB;

    private ConnectionToDB() {
    }

    public static ConnectionToDB getInstance() {
        if (connectionToDB == null) {
            connectionToDB = new ConnectionToDB();
        }
        return connectionToDB;
    }

    private static String url = "";
    private static String username = "";
    private static String password = "";
    private static String jdbcDriver = "";

    public static void setValue() {
        try {

            InputStream inputStream = ConnectionToDB.class.getClassLoader().getResourceAsStream("config-db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
            jdbcDriver = properties.getProperty("db.jdbc-driver");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            setValue();
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
