package com.mapsa.orm.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionToDB {

    private String url;
    private String user;
    private String password;
    private String jdbcDriver;

    private static Connection connection;
    private static ConnectionToDB connectionToDB;

    private ConnectionToDB() throws IOException, SQLException {
        readConfig();
        getConnection();
    }

    public void getConnection() throws SQLException {

        connection = DriverManager.getConnection(url, user, password);
    }

    public static Connection getConnectionToDB() throws IOException, SQLException {
        if (connectionToDB == null) {
            connectionToDB = new ConnectionToDB();
        }

        return connection;
    }

    public void readConfig() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("my.properties");
        properties.load(inputStream);
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        jdbcDriver = properties.getProperty("jdbcDriver");

    }

}
