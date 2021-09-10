import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionToDB {
    private static String url;
    private static String user;
    private static String password;
    private static String jdbcDriver;
    static Connection connection;
    static ConnectionToDB connectionToDB;

    private ConnectionToDB() {
        readConfig();
        getConnection();

    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static Connection getMyConnection() {
        if (connectionToDB == null) {
            connectionToDB = new ConnectionToDB();
        }
        return connection;
    }


    public static void readConfig(){
        Properties properties = new Properties();
        InputStream inputStream = ConnectionToDB.class.getClassLoader().getResourceAsStream("my.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        jdbcDriver = properties.getProperty("jdbcDriver");

    }
}
