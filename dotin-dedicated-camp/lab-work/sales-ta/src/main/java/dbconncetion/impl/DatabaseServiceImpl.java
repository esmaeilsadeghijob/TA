package dbconncetion.impl;

import dbconncetion.DatabaseService;
import org.postgresql.util.PSQLException;

import java.sql.*;

public class DatabaseServiceImpl implements DatabaseService {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.jdbc.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/mapsa";
    // Database credential
    static final String Username = "postgres";
    static final String Password = "admin";
    static Connection connection;
    static Statement statement;
    // making our service threadsafe and also singleton
    private static DatabaseServiceImpl instance;

    private DatabaseServiceImpl() {
    }

    // Using double checking
    public static DatabaseServiceImpl getInstance() {
        if (instance == null) {
            synchronized (DatabaseServiceImpl.class) {
                if (instance == null) {
                    instance = new DatabaseServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Connection openConnection() throws Exception {
        // Registers JDBC driver
        Class.forName("org.postgresql.Driver");

        // Opens a connection and returns it
        return connection = DriverManager.getConnection(DB_URL, Username, Password);
    }

    @Override
    public void closeConnection() throws Exception {
        connection.close();
        statement.close();
    }

    @Override
    public ResultSet getAll(TableName tableName, String optional) throws SQLException {
        String sql = "SELECT * FROM \"SALES_" + tableName.toString().toUpperCase() + "\"";
        if (optional != null) {
            sql += " " + optional + ";";
        } else {
            sql += ";";
        }
        if (connection == null) {
            try {
                connection = openConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statement.executeQuery(sql);
    }

    @Override
    public void saveData(TableName tableName, String values) throws Exception {
        String sql = "";
        if (values.isEmpty())
            System.err.println("Values must not be empty!");
        else {
            if (tableName.equals(TableName.User)) {
                sql = "insert into \"SALES_USER\" (id, username, password, suggested_price) VALUES (" + values + ");";
            }
            if (tableName.equals(TableName.Product)) {
                sql = "insert into \"SALES_PRODUCT\" (id, name, base_price) VALUES (" + values + ");";
            }
            if (connection != null && sql != "") {
                try {
                    statement = connection.createStatement();
                    statement.executeQuery(sql).close();
                } catch (PSQLException e) {
                }
            } else {
                System.err.println("your connection is closed! or you didn't select any table~~~");
            }
        }
        closeConnection();
    }

    @Override
    public void updateData(TableName tableName, String name, String password, long price, long id) throws Exception {
        String sql = "";
        if (name.isEmpty())
            System.err.println("Values must not be empty!");
        else {
            if (tableName.equals(TableName.User)) {
                sql = "UPDATE \"SALES_USER\" " +
                        "SET username = \'" + name + "\' , " +
                        "password = \'" + password + "\' , " +
                        "suggested_price = " + price + " " +
                        "WHERE id = " + id + ";";
            }
            if (tableName.equals(TableName.Product)) {
                sql = "UPDATE \"SALES_PRODUCT\" " +
                        "SET name = \'" + name + "\', base_price =" + price + " " +
                        "WHERE id = " + id + ";";
            }
            if (connection != null && sql != "") {
                try {
                    statement = connection.createStatement();
                    statement.executeQuery(sql).close();
                } catch (PSQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("your connection is closed! or you didn't select any table~~~");
            }
        }
        closeConnection();
    }
}
