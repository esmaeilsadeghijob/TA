package com.mapsa.orm.databaseworktools;

import com.mapsa.orm.annotation.Column;
import com.mapsa.orm.annotation.Table;
import com.mapsa.orm.database.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class AddRecord implements Tools {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Scanner scanner;
    Statement statement;
    Connection connection;
    DBConnection dbConnection;
    PreparedStatement preparedStatement;

    public AddRecord() throws IOException, SQLException {

        scanner = new Scanner(System.in);
        dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
        statement = connection.createStatement();

    }

    public void addRecordToTable(Object object) {

        String tableName = object.getClass().getDeclaredAnnotation(Table.class).name().equals("") ?
                object.getClass().getSimpleName() : object.getClass().getDeclaredAnnotation(Table.class).name();

        try {

            String query = "INSERT INTO " + tableName + " (";

            Field[] fields = object.getClass().getDeclaredFields();
            ArrayList<String> paramValue = new ArrayList<>();
            for (Field field : fields) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {

                    if (annotation instanceof Column) {
                        Column column = field.getAnnotation(Column.class);
                        query += column.name() + ",";
                        Field tFiled = object.getClass().getDeclaredField(field.getName());
                        tFiled.setAccessible(true);
                        paramValue.add(String.valueOf(tFiled.get(object)));
                    }

                }
            }
            if (query.endsWith(",")) {
                query = query.substring(0, query.length() - 1);
            }
            query += ") VALUES ( ";

            for (int i = 0; i < paramValue.size(); i++) {
                query += "?,";
            }

            if (query.endsWith(",")) {
                query = query.substring(0, query.length() - 1);
            }
            query += " )";


            preparedStatement = connection.prepareStatement(query);

            for (int i = 0; i < paramValue.size(); i++) {
                preparedStatement.setString(i + 1, paramValue.get(i));
            }

            preparedStatement.executeUpdate();


            logger.info("user add a record to " + tableName + " table");

        } catch (Exception ex) {

            logger.error("User try to delete an record from " + tableName + " but get an Exception");
            ex.printStackTrace();

        }

    }

}
