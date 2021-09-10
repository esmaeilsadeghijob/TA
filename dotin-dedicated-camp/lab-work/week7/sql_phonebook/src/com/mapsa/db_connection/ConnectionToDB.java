package com.mapsa.db_connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionToDB {

    private String url;
    private String username;
    private String password;
    private String jdbcDriver;
    private Statement statement;
    private Connection connection;
    private static ConnectionToDB ctd;

    private ConnectionToDB() {
        setConfig();
        setConnection();
    }

    private void setConfig() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("conf/db-config.properties"));
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            jdbcDriver = prop.getProperty("jdbc-driver");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void setConnection() {
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionToDB getInstance() {
        if (ctd == null) {
            ctd = new ConnectionToDB();
        }
        return ctd;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}