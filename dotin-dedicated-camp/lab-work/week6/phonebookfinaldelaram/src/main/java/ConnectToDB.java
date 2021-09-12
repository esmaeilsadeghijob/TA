
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

public class ConnectToDB {

    public Connection setValue() throws IOException, SQLException {

        File file = new File("dbconnection.properties");
        InputStream inputStream = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(inputStream);
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        String driverName = prop.getProperty("jdbcDriver");
        Connection connectionMySQL = null;
        connectionMySQL = DriverManager.getConnection(url,username, password);
        Statement statement;
        statement = connectionMySQL.createStatement();

        return connectionMySQL;
    }


}
