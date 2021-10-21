package DB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static String url = "";
    private static String username = "";
    private static String password = "";
    private static String jdbcDriver = "";

    private Connection connection;
    private static DBConnection dbConnection;

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        synchronized (DBConnection.class) {
            if (dbConnection == null) {
                dbConnection = new DBConnection();
            }
        }
        return dbConnection;
    }

    public Connection getConnection() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("aplication.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        jdbcDriver = properties.getProperty("jdbc_Driver");

        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
