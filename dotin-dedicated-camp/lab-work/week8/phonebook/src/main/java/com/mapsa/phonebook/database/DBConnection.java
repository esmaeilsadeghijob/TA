package com.mapsa.phonebook.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//This class connects to the database, and is written based on bill pugh singleton design pattern
public class DBConnection {
    private Connection connection;

    private DBConnection(){
    }

    private static class DBConnectionInner{
        private static final DBConnection dbConnection = new DBConnection();
    }

    public Connection getConnection() throws IOException {
        //Getting the connection information from the application.properties file
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        String driver = properties.getProperty("jdbc-driver");

        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DBConnection getInstance(){
        return DBConnectionInner.dbConnection;
    }
    }
