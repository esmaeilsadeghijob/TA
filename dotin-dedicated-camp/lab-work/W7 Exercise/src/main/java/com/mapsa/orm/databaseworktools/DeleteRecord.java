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

public class DeleteRecord implements Tools{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Scanner scanner;
    Statement statement;
    Connection connection;
    DBConnection dbConnection;
    PreparedStatement preparedStatement;

    public DeleteRecord() throws IOException, SQLException {

        scanner = new Scanner(System.in);
        dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
        statement = connection.createStatement();

    }

    public void deleteRecordFromTable (Object object) {

        String tableName = object.getClass().getDeclaredAnnotation(Table.class).name().equals("")
                ? object.getClass().getSimpleName() : object.getClass().getDeclaredAnnotation(Table.class).name();

        String columnName = null;

        try {

            ArrayList<String> paramValue = new ArrayList<>();
            String query = "DELETE FROM " + tableName + " WHERE ";
            Field[] fields = object.getClass().getDeclaredFields();

            for (Field field : fields) {
                Annotation[] annotations = field.getDeclaredAnnotations();

                for (Annotation annotation : annotations) {

                    if (annotation instanceof Id) {

                        columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
                        query += columnName + "=? ";
                        Field objectFiled = object.getClass().getDeclaredField(field.getName());
                        objectFiled.setAccessible(true);
                        paramValue.add(String.valueOf(objectFiled.get(object)));
                    }
                }
            }

            preparedStatement = connection.prepareStatement(query);


            for (int i = 0; i < paramValue.size(); i++) {
                preparedStatement.setObject(i + 1, paramValue.get(i));
            }

            preparedStatement.executeUpdate();

            logger.info("user delete the record " + String.valueOf(columnName) + " of " + tableName);

        } catch (SQLException | IllegalAccessException | NoSuchFieldException ex) {

            logger.error("User try to delete an record from " + tableName + " but get an Exception");
            ex.printStackTrace();

        }

    }

}
