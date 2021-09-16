package com.mapsa.orm.database;

import com.mapsa.orm.persistence.Column;
import com.mapsa.orm.persistence.GeneratedValue;
import com.mapsa.orm.persistence.Id;
import com.mapsa.orm.persistence.Table;
import org.adeptnet.sql.NamedParameterStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUDGenerator<T> implements JdbcCrud<T> {
    private final static Logger logger = LoggerFactory.getLogger(CRUDGenerator.class);
    public Connection connection;
    public PreparedStatement preparedStatement;

    @Override
    public void create(T t) throws Exception {
        String query;

        connection = DBConnection.getInstance().getConnection();

        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();

        query = "CREATE TABLE " + TableName + " (";

        Field[] fields = t.getClass().getDeclaredFields();

        for (Field field : fields) {

            Annotation[] annotations = field.getDeclaredAnnotations();

            for (Annotation annotation : annotations) {

                if (annotation instanceof Id) {

                    String name = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
                    String type = field.getAnnotation(Column.class) == null ? field.getType().getSimpleName() : field.getAnnotation(Column.class).dataType();

                    if (type.equals("NUMBER") || type.equals("Long") || type.equals("long") || type.equals("int")
                            || type.equals("Integer")) {

                        query += name + " " + type + " PRIMARY KEY ,";

                    } else {
                        query += name + "Number" + " PRIMARY KEY ,";
                    }

                } else if (annotation instanceof GeneratedValue) {
                    String strategy = ((GeneratedValue) annotation).strategy();
                    String generator = ((GeneratedValue) annotation).generator().equals("") ? "HIBERNATE_SEQUENCE" : ((GeneratedValue) annotation).generator();

                    if (strategy.equalsIgnoreCase("AUTO") || strategy.equalsIgnoreCase("SEQUENCE")) {
                        preparedStatement = connection.prepareStatement("create sequence " + generator + " start with 1 INCREMENT BY 1");
                    }
                    preparedStatement.execute();
                    System.out.println("create sequence " + generator + " start with 1 INCREMENT BY 1");

                } else if (annotation instanceof Column && field.getAnnotation(Id.class) == null) {

                    Column column = (Column) annotation;

                    if (column.dataType().equals("NUMBER")) {
                        query += column.name() + " " + column.dataType() + ",";
                    } else {
                        query += column.name() + " " + column.dataType() + "(" + column.length() + ") " + ",";
                    }
                }
            }
        }
        if (query.endsWith(",")) {
            query = query.substring(0, query.length() - 1);
        }
        query += ")";

        String text = "create table";
        logger.info("Class Name: {} , {} ... ", CRUDGenerator.class.getSimpleName(), text);
        System.out.println(query);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
    }

    public void save(T t) throws Exception {

        String query;
        connection = DBConnection.getInstance().getConnection();
        ArrayList<Object> paramValue = new ArrayList<>();

        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();

        query = "INSERT INTO " + TableName + " (";

        Field[] fields = t.getClass().getDeclaredFields();

        for (Field field : fields) {

            Annotation[] annotations = field.getDeclaredAnnotations();

            for (Annotation annotation : annotations) {

                Field tFiled = t.getClass().getDeclaredField(field.getName());
                tFiled.setAccessible(true);

                if (annotation instanceof Column && field.getAnnotation(Id.class) == null) {
                    String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
                    query += columnName + ",";
                    paramValue.add(tFiled.get(t));

                } else if (annotation instanceof Id) {

                    String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
                    query += columnName + ",";
                    String generator = field.getAnnotation(GeneratedValue.class).generator().equals("") ? "HIBERNATE_SEQUENCE" : field.getAnnotation(GeneratedValue.class).generator();

                    preparedStatement = connection.prepareStatement("select " + generator + ".nextval id from dual");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    resultSet.next();
                    long id = resultSet.getLong("id");

                    paramValue.add(id);

                    tFiled.set(t, id);
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

        String text = "insert";
        logger.info("Class Name: {} , {} ... ", CRUDGenerator.class.getSimpleName(), text);
        System.out.println(query);


        preparedStatement.executeUpdate();
    }

    @Override
    public void update(T t) throws Exception {

        String query;
        String setClause = "";
        String whereClause = "";

        connection = DBConnection.getInstance().getConnection();

        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();

        query = "UPDATE " + TableName + " SET ";

        Field[] fields = t.getClass().getDeclaredFields();
        Map<String, Object> paramValue = new HashMap<>();

        for (Field field : fields) {

            String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
            Field tFiled = t.getClass().getDeclaredField(field.getName());
            tFiled.setAccessible(true);
            paramValue.put(field.getName(), tFiled.get(t));

            if (field.getAnnotation(Id.class) == null) {
                setClause += columnName + " =:" + field.getName() + ",";
            } else {
                whereClause = "where " + columnName + " =:" + field.getName();
            }
        }

        if (setClause.endsWith(",")) {
            setClause = setClause.substring(0, setClause.length() - 1);
        }

        query += setClause + " " + whereClause;
        NamedParameterStatement preparedStatement = new NamedParameterStatement(connection, query);

        for (String paramName : paramValue.keySet()) {
            preparedStatement.setObject(paramName, paramValue.get(paramName));
        }

        String text = "update";
        logger.info("Class Name: {} , {} ... ", CRUDGenerator.class.getSimpleName(), text);
        System.out.println(query);

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(T t) throws Exception {

        String query;
        connection = DBConnection.getInstance().getConnection();
        ArrayList<Object> paramValue = new ArrayList<>();

        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();

        query = "DELETE FROM " + TableName + " WHERE ";

        Field[] fields = t.getClass().getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();

            for (Annotation annotation : annotations) {

                if (annotation instanceof Id) {

                    String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
                    query += columnName + "=? ";
                    Field tFiled = t.getClass().getDeclaredField(field.getName());
                    tFiled.setAccessible(true);
                    paramValue.add(tFiled.get(t));
                }
            }
        }

        preparedStatement = connection.prepareStatement(query);

        for (int i = 0; i < paramValue.size(); i++) {
            preparedStatement.setObject(i + 1, paramValue.get(i));
        }

        String text = "DELETE";
        logger.info("Class Name: {} , {} ... ", CRUDGenerator.class.getSimpleName(), text);
        System.out.println(query);

        preparedStatement.executeUpdate();
    }

    @Override
    public List<T> selectAll(Class<T> tClass) throws Exception {

        String query;
        connection = DBConnection.getInstance().getConnection();
        T t = tClass.newInstance();
        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();

        query = "SELECT * FROM " + TableName;

        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<T> resultList = new ArrayList<>();
        while (resultSet.next()) {
            t = tClass.newInstance();
            Field[] fields = t.getClass().getDeclaredFields();

            for (Field field : fields) {

                String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();

                Field tFiled = t.getClass().getDeclaredField(field.getName());
                tFiled.setAccessible(true);

                switch (tFiled.getType().getSimpleName()) {
                    case "Long":
                    case "long":
                        tFiled.set(t, resultSet.getLong(columnName));
                        break;
                    case "int":
                    case "Integer":
                        tFiled.set(t, resultSet.getInt(columnName));
                        break;
                    case "String":
                        tFiled.set(t, resultSet.getString(columnName));
                        break;
                    case "float":
                        tFiled.set(t, resultSet.getFloat(columnName));
                        break;
                    case "double":
                        tFiled.set(t, resultSet.getDouble(columnName));
                }
            }
            resultList.add(t);
        }

        String text = "SELECT ALL";
        logger.info("Class Name: {} , {} ... ", CRUDGenerator.class.getSimpleName(), text);
        System.out.println(query);

        return resultList;

    }

    @Override
    public T selectById(Class<T> tClass, Long id) throws Exception {

        String query;
        connection = DBConnection.getInstance().getConnection();

        T t = tClass.newInstance();

        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();

        query = "SELECT * FROM " + TableName + " WHERE ";

        Field[] fields = t.getClass().getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();

            for (Annotation annotation : annotations) {

                if (annotation instanceof Id) {

                    String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();
                    query += columnName + "= " + id;

                }
            }
        }
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            t = tClass.newInstance();
            Field[] fieldss = t.getClass().getDeclaredFields();

            for (Field field : fieldss) {

                String columnName = field.getAnnotation(Column.class) == null ? field.getName() : field.getAnnotation(Column.class).name();

                Field tFiled = t.getClass().getDeclaredField(field.getName());
                tFiled.setAccessible(true);

                switch (tFiled.getType().getSimpleName()) {
                    case "Long":
                    case "long":
                        tFiled.set(t, resultSet.getLong(columnName));
                        break;
                    case "int":
                    case "Integer":
                        tFiled.set(t, resultSet.getInt(columnName));
                        break;
                    case "String":
                        tFiled.set(t, resultSet.getString(columnName));
                        break;
                    case "float":
                        tFiled.set(t, resultSet.getFloat(columnName));
                        break;
                    case "double":
                        tFiled.set(t, resultSet.getDouble(columnName));
                }
            }
        }

        String text = "SELECT BY ID";
        logger.info("Class Name: {} , {} ... ", CRUDGenerator.class.getSimpleName(), text);
        System.out.println(query);

        return t;
    }

    @Override
    public void close() throws SQLException {
        preparedStatement.close();
        connection.close();
    }
}
