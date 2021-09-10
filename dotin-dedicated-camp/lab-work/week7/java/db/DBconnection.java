package com.mapsa.Mybook.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnection {
    private static DBconnection instance = null;
    private Connection connection;
    private PreparedStatement preparedStatement;

    public DBconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws IOException, SQLException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("app.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


    public static DBconnection getInstance(){
        if (instance == null){
            instance = new DBconnection();
        }
        return instance;
    }
}
