package com.mapsa.database;

import com.mapsa.persistence.Column;
import com.mapsa.persistence.Id;
import com.mapsa.persistence.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudGenerator<T> implements JdbcCrud<T> {
    public Connection connection;
    public PreparedStatement preparedStatement;

    @Override
    public void create(T t) throws Exception {
        String query;
        connection = DBConnection.getInstance().getConnection();

        String tableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();
        query = "create table " + tableName + " (";
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {

                if (annotation instanceof Id) {
                    String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
                    query += columnName + " NUMBER PRIMARY KEY,";
                } else if (annotation instanceof Column && field.getAnnotation(Id.class) == null) {
                    Column column = field.getAnnotation(Column.class);
                    String columnName = field.getAnnotation(Column.class).name().equals("") ? field.getName() : field.getAnnotation(Column.class).name();
                    query += columnName + " " + column.dataType() + "(" + column.length() + "),";
                }
            }
        }
        if (query.endsWith(",")) {
            query = query.substring(0, query.length() - 1);
        }
        query += ")";
        System.out.println(query);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
    }

    @Override
    public void save(T t) throws Exception {
        String query;
        connection = DBConnection.getInstance().getConnection();
        ArrayList<Object> paramValue = new ArrayList<>();

        String tableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();
        query = "insert into " + tableName + " (";
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                Field tFiled = t.getClass().getDeclaredField(field.getName());
                tFiled.setAccessible(true);
                if (annotation instanceof Id) {
                    String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
                    query += columnName + ",";
                    paramValue.add(tFiled.get(t));

                }
                if (annotation instanceof Column && field.getAnnotation(Id.class) == null) {
                    String columnName = field.getAnnotation(Column.class).name().equals("") ? field.getName() : field.getAnnotation(Column.class).name();
                    query += columnName + ",";
                    paramValue.add(tFiled.get(t));

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
            preparedStatement.setObject(i + 1, paramValue.get(i));
        }
        preparedStatement.executeUpdate();
        System.out.println(query);

    }

    @Override
    public void update(T t) throws Exception {
        String query;
        String set = "";
        String where = "";

        connection = DBConnection.getInstance().getConnection();
        Map<String , Object> map = new HashMap<>();

        String tableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();
        query = "update " + tableName ;
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            Field tFiled = t.getClass().getDeclaredField(field.getName());
            tFiled.setAccessible(true);
            map.put(field.getName(), tFiled.get(t));

            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {

                if (annotation instanceof Id) {
                    String columnName = field.getAnnotation(Column.class).name().equals("") ? field.getName() : field.getAnnotation(Column.class).name();
                    where += "where " + columnName + "=?";

                }
                else if (annotation instanceof Column && field.getAnnotation(Id.class) == null) {
                    String columnName = field.getAnnotation(Column.class).name().equals("") ? field.getName() : field.getAnnotation(Column.class).name();
                    set +=" set "+ columnName + "=?,";
                }
            }

        }
        if (set.endsWith(",")) {
            set = set.substring(0, set.length() - 1);
        }
        query += set + " " +where;
        preparedStatement = connection.prepareStatement(query);
        // TODO: 10/21/2021
        preparedStatement.executeUpdate();
        System.out.println(query);
    }

    @Override
    public void delete(T t) throws Exception {
        String query;
        connection = DBConnection.getInstance().getConnection();
        ArrayList<Object> paramValue = new ArrayList<>();

        String tableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();
        query = "delete from " + tableName + " where ";
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                Field tFiled = t.getClass().getDeclaredField(field.getName());
                tFiled.setAccessible(true);
                if (annotation instanceof Id) {
                    String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
                    query += columnName + "=?";
                    paramValue.add(tFiled.get(t));

                }
            }
        }

        preparedStatement = connection.prepareStatement(query);

        for (int i = 0; i < paramValue.size(); i++) {
            preparedStatement.setObject(i + 1, paramValue.get(i));
        }
        preparedStatement.executeUpdate();
        System.out.println(query);
    }

    @Override
    public List selectAll(Class aClass) throws Exception {
        return null;
    }

    @Override
    public Object selectById(Class aClass, Long id) throws Exception {
        return null;
    }

    @Override
    public void close() throws SQLException {

    }
}
