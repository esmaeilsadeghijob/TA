package com.niloofar.orm.JDBC;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCSingleton {
    private static String url = "";
    private static String username = "";
    private static String password = "";
    private static String jdbcDriver = "";

    private static JDBCSingleton jdbc;
    private static Connection con=null;

    private JDBCSingleton() {
        try {
            InputStream inputStream = JDBCSingleton.class.getClassLoader().getResourceAsStream("application.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty("db.url");
            password = properties.getProperty("db.password");
            username = properties.getProperty("db.username");
            jdbcDriver = properties.getProperty("db.jdbc-driver");
            Class.forName(jdbcDriver);
        con = DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException | IOException | SQLException e ){
            e.printStackTrace();
        }
    }

    public static JDBCSingleton getInstance(){

        if (jdbc==null)
        {
            jdbc=new JDBCSingleton();
        }
        return jdbc;
    }


    public static Connection getConnection(){
       return con;
    }



}
