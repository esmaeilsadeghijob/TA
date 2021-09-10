package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
    private static String url = "";
    private static String username = "";
    private static String password = "";
    private static String jdbcDriver = "";
    private static Connection connection = null;


    public static void setvalue(){
        try {
            InputStream inputStream=ConnectionDB.class.getClassLoader().getResourceAsStream("ConfigDB.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            url=properties.getProperty("db.url");
            password=properties.getProperty("db.password");
            username=properties.getProperty("db.username");
            jdbcDriver=properties.getProperty("db.jdbc-driver");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

