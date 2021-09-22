package com.nebula.phonenumberbook;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static String url = "";
    private static String driverName = "";
    private static String username = "";
    private static String password = "";
    private static Connection con;


    public void setValue(){
        try {

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config-db.properties");
            Properties prop = new Properties();
            prop.load(inputStream);
            url = prop.getProperty("db.url");
            username = prop.getProperty("db.username");
            password = prop.getProperty("db.password");
            driverName = prop.getProperty("db.jdbcDriver");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = (Connection) DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }

        return con;
    }

}
