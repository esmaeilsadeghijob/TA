package com.mapsa.orm.databaseworktools;

import com.mapsa.orm.annotation.Table;
import com.mapsa.orm.database.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class ShowAllRecord implements Tools{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Scanner scanner;
    Statement statement;
    Connection connection;
    DBConnection dbConnection;
    PreparedStatement preparedStatement;

    public ShowAllRecord() throws IOException, SQLException {

        scanner = new Scanner(System.in);
        dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
        statement = connection.createStatement();

    }

    public void showAllRecordOfTables(Object object) {

        String tableName = object.getClass().getDeclaredAnnotation(Table.class).name().equals("") ?
                object.getClass().getSimpleName() : object.getClass().getDeclaredAnnotation(Table.class).name();

        try {

            String query = "SELECT * FROM " + tableName;

            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnsNumber = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {

                for (int i = 1; i <= columnsNumber; i++) {

                    System.out.print(resultSet.getString(i) + " ");

                }

                System.out.println();

            }

            logger.info("User show all record from " + tableName);

        }  catch (SQLException ex) {

            logger.error("User try to update an record from " + tableName + " but get an Exception");
            ex.printStackTrace();
        }

    }

}
