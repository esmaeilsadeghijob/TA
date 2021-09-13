package com.phonebook.database;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class ConnectionDB2 {
    private static Connection connection;
    private static ConnectionDB2 dbConnections;
    private String url, username, password;
//    private static  Logger LOG = LoggerFactory.getLogger(ConnectionDB2.class);

    private ConnectionDB2() {
        readConfig();
        getConnectiondb();
    }

    public static Connection getConnection() {

        synchronized (ConnectionDB2.class) {
            if (dbConnections == null)
                dbConnections = new ConnectionDB2();
        }

        return connection;
    }

    private Connection getConnectiondb() {
        try {

            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void readConfig() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config-db.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        password = properties.getProperty("password");
        username = properties.getProperty("username");
    }








}

