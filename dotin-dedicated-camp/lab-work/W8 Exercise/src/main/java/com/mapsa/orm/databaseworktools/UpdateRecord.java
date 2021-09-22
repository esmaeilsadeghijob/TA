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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateRecord implements Tools {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Scanner scanner;
    Statement statement;
    Connection connection;
    DBConnection dbConnection;
    PreparedStatement preparedStatement;

    public UpdateRecord() throws IOException, SQLException {

        scanner = new Scanner(System.in);
        dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
        statement = connection.createStatement();

    }

    public void updateARecordOfTable(Object object) {

        String tableName = object.getClass().getDeclaredAnnotation(Table.class).name().equals("")
                ? object.getClass().getSimpleName() : object.getClass().getDeclaredAnnotation(Table.class).name();

        try {

            ArrayList<String> paramValue = new ArrayList<>();
            String query = "UPDATE " + tableName + " set ";
            Field[] fields = object.getClass().getDeclaredFields();

            for (Field field : fields) {

                Annotation[] annotations = field.getDeclaredAnnotations();

                for (Annotation annotation : annotations) {

                    if (annotation instanceof Column && field.getAnnotation(Id.class) == null) {

                        String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();

                        query += columnName + " = " + "? " + ",";
                        Field objectFiled = object.getClass().getDeclaredField(field.getName());
                        objectFiled.setAccessible(true);
                        paramValue.add(String.valueOf(objectFiled.get(object)));

                    }

                }

            }

            if (query.endsWith(",")) {
                query = query.substring(0, query.length() - 1);
            }

            query += " Where ";


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

            preparedStatement = connection.prepareStatement(query);

            for (int i = 0; i < paramValue.size(); i++) {
                preparedStatement.setString(i + 1, paramValue.get(i));
            }

            preparedStatement.executeUpdate();

            logger.info("User update an record from " + tableName);

        } catch (SQLException | IllegalAccessException | NoSuchFieldException ex) {

            logger.error("User try to update an record from " + tableName + " but get an Exception");
            ex.printStackTrace();
        }

    }

}
