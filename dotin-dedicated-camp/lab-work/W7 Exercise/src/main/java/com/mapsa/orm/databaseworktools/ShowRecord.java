package com.mapsa.orm.databaseworktools;

import com.mapsa.orm.annotation.Column;
import com.mapsa.orm.annotation.Id;
import com.mapsa.orm.annotation.Table;
import com.mapsa.orm.database.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ShowRecord implements Tools{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Scanner scanner;
    Statement statement;
    Connection connection;
    DBConnection dbConnection;
    PreparedStatement preparedStatement;

    public ShowRecord() throws IOException, SQLException {

        scanner = new Scanner(System.in);
        dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
        statement = connection.createStatement();

    }

    public void showARecordOfTable(Object object) {

        String tableName = object.getClass().getDeclaredAnnotation(Table.class).name().equals("") ?
                object.getClass().getSimpleName() : object.getClass().getDeclaredAnnotation(Table.class).name();

        try {

            String query = "select ";

            Field[] fields = object.getClass().getDeclaredFields();
            ArrayList<String> paramValue = new ArrayList<>();

            for (Field field : fields) {
                Annotation[] annotations = field.getDeclaredAnnotations();

                for (Annotation annotation : annotations) {

                    if (annotation instanceof Column) {
                        Column column = field.getAnnotation(Column.class);
                        query += column.name() + " ,";
                        Field tFiled = object.getClass().getDeclaredField(field.getName());
                        tFiled.setAccessible(true);
                        paramValue.add(String.valueOf(tFiled.get(object)));
                    }
                }
            }

            if (query.endsWith(",")) {
                query = query.substring(0, query.length() - 1);
            }

            query += "From " + tableName + " where ";

            for (Field field : fields) {

                Annotation[] annotations = field.getDeclaredAnnotations();

                for (Annotation annotation : annotations) {

                    Field objectFiled1 = object.getClass().getDeclaredField(field.getName());
                    objectFiled1.setAccessible(true);

                    if (annotation instanceof Id) {

                        String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
                        query += columnName + " = " + objectFiled1.get(object);

                    }

                }

            }

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                System.out.println(resultSet.getInt(1) + " " +
                        resultSet.getString(2) + " " +
                        resultSet.getString(3));
            }

            logger.info("User show record in table " + tableName);

        } catch (Exception ex) {

            logger.error("User try to delete an record from " + tableName + "but get an Exception");
            ex.printStackTrace();

        }

    }

}
