package database;

import anotations.Column;
import anotations.Key;
import anotations.Table;
import connections.ConnectionToDB;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUDImp {
    private Class tableClass;
    private Connection connection;

    public CRUDImp(Class tableClass) {
        this.tableClass = tableClass;
        try {
            connection = ConnectionToDB.getConnectionToDB();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void create() throws SQLException, ClassNotFoundException {
        Annotation[] annotations = tableClass.getAnnotations();
        for (Annotation tableAnnotation : annotations) {
            if (tableAnnotation instanceof Table) {
                String tableName = ((Table) tableAnnotation).name() == null ? tableClass.getName() :
                        ((Table) tableAnnotation).name();
                String queryExist = "SELECT * FROM " + tableName;
                boolean isExist = true;
                try {
                    connection.createStatement().execute(queryExist);
                } catch (SQLException e) {
                    isExist = false;
                }
                if (isExist)
                    return;
                Field[] fields = tableClass.getDeclaredFields();
                Map<String, String> map = new HashMap<>();
                int keyCount = 0;
                for (Field field : fields) {
                    field.setAccessible(true);
                    Annotation[] fieldAnnotations = field.getAnnotations();
                    for (Annotation annotation : fieldAnnotations) {
                        if (annotation instanceof Column) {
                            String columnName = ((Column) annotation).name() == null ? field.getName() :
                                    ((Column) annotation).name();
                            String dataType = field.getType().getSimpleName();
                            switch (dataType) {
                                case "int":
                                    dataType = "INTEGER";
                                    break;
                                case "String":
                                    dataType = "VARCHAR";
                                    break;
                                //TODO add other primitive data types
                            }
                            dataType += ("(" + ((Column) annotation).length() + ")");
                            // add start end of table's key
                            if (field.isAnnotationPresent(Key.class)) {
                                keyCount++;
                                dataType += "*";
                            }
                            map.put(columnName, dataType);
                        }
                    }
                }
                String parameters = "";
                List<String> keyList = new ArrayList<>();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    parameters += entry.getKey() + " " + (entry.getValue().endsWith("*") ?
                            entry.getValue().substring(0, entry.getValue().length() - 1) :
                            entry.getValue()) + " ";
                    if (keyCount == 1 && entry.getValue().endsWith("*")) {
                        parameters += "PRIMARY KEY";
                    } else if (keyCount > 1 && entry.getValue().endsWith("*")) {
                        keyList.add(entry.getKey());
                    }
                    parameters += ", ";
                }
                if (!keyList.isEmpty()) {
                    parameters += "PRIMARY KEY (";
                    for (String list : keyList) {
                        parameters += list + ", ";
                    }
                    parameters = parameters.substring(0, parameters.length() - 2);
                    parameters += ")  ";
                }
                parameters = parameters.substring(0, parameters.length() - 2);
                String sql = "CREATE TABLE " + tableName + "(" + parameters + ");";
                System.out.println(sql);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }
        }
    }

    public void addRecord(Object object) throws IllegalAccessException {
        List<Object> fieldList = new ArrayList<>();
        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        String query = "insert into " + table.name() + " (";
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Column) {
                    Column column = field.getAnnotation(Column.class);
                    String columnName = ((Column) annotation).name() == null ? field.getName() :
                            ((Column) annotation).name();
                    query += columnName + ", ";
                    String dataType = field.getType().getSimpleName();
                    if (dataType.equals("String")) {
                        fieldList.add("\'" + field.get(object) + "\'");
                    } else {
                        fieldList.add(field.get(object));
                    }
                }
            }
        }
        query = query.substring(0, query.length() - 2);
        query += ") values (";
        for (Object obj : fieldList) {
            query += obj + ", ";
        }
        query = query.substring(0, query.length() - 2);
        query += ");";
        System.out.println(query);
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRow(Object t, int id) throws Exception {
        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name().equals("") ?
                t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();
        String query = "DELETE FROM " + TableName + " WHERE ";
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Key) {
                    Column column = field.getAnnotation(Column.class);
                    String columnName = column.name() == null ? field.getName() : column.name();
                    query += columnName;
                }
            }
        }
        query += (" = " + id +";");
        System.out.println(query);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void update(Object p,int id) throws SQLException {
        ArrayList<String> f1 = new ArrayList<>();
        Table table = p.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder query2 = new StringBuilder();
        query2.append("UPDATE "+ table.name() + " set ");
        Field[] fields = p.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {

                if (annotation instanceof Column && field.getAnnotation(Key.class) == null) {
                    Column column = field.getAnnotation(Column.class);
                    String columnName = column.name() == null ? field.getName() : column.name();
                    query2.append(columnName + " = " + "? " + ",");
                    Field of = null;
                    try {
                        of = p.getClass().getDeclaredField(field.getName());
                        of.setAccessible(true);
                        f1.add(String.valueOf(of.get(p)));
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        String end= query2.toString();
        if (end.endsWith(",")) {
            end= end.substring(0, query2.length() - 1);
        }
        end += " Where ";
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Key) {
                    Column column = field.getAnnotation(Column.class);
                    String columnName = column.name() == null ? field.getName() : column.name();
                    end += columnName;
                }
            }
        }
        end += ("=" + id);
        System.out.println(end);
        PreparedStatement preparedStatement = connection.prepareStatement( end);
        for (int i = 0; i < f1.size(); i++) {
            preparedStatement.setString(i + 1, f1.get(i));
        }
        preparedStatement.executeUpdate();
    }
}
