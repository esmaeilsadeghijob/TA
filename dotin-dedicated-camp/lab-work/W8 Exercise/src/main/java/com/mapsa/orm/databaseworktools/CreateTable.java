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
import java.util.Scanner;

public class CreateTable implements Tools{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Scanner scanner;
    Statement statement;
    Connection connection;
    DBConnection dbConnection;
    PreparedStatement preparedStatement;

    public CreateTable() throws IOException, SQLException {

        scanner = new Scanner(System.in);
        dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
        statement = connection.createStatement();

    }

    public void createTableInDatabase(Object object) {

        String tableName = object.getClass().getDeclaredAnnotation(Table.class).name().equals("") ?
                object.getClass().getSimpleName() : object.getClass().getDeclaredAnnotation(Table.class).name();

        try {

            String query = "CREATE TABLE " + tableName + " (";
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {

                    if (annotation instanceof Column) {
                        Column column = field.getAnnotation(Column.class);
                        query += column.name() + " " + column.dataType() + "(" + column.length() + "),";

                    }
                }

            }

            if (query.endsWith(",")) {
                query = query.substring(0, query.length() - 1);
            }

            query += ") ";

            logger.info("User create table " + tableName);

            System.out.println("create table " + object.getClass().getSimpleName());
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

        }  catch (SQLException ex) {

            logger.error("User try to update an record from " + tableName + " but get an Exception");
            ex.printStackTrace();
        }

    }

}
