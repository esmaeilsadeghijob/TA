package DB;

import annot.Column;
import annot.Id;
import annot.Table;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import sun.nio.cs.Surrogate;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActOfDB {
    public Connection connection;
    public PreparedStatement preparedStatement;
    public String query;
    public void creat(Object o) throws SQLException, IOException {
        DBConnection.getInstance().getConnection();
        StringBuilder query = new StringBuilder();
        Table table = o.getClass().getDeclaredAnnotation(Table.class);
        query.append("CREATE TABLE " + table.name() + " (");
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Column) {
                    Column coloumn = field.getAnnotation(Column.class);
                    query.append(coloumn.name() + " " + coloumn.dataType() + "("+coloumn.size() +")");
                }
            }
        }
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Id) {
                    Column column = field.getAnnotation(Column.class);
                    query.append(" PRIMARY KEY (`" + column.name() + "`)");
                }
            }
        }

        String query1 = query.toString();
        if (query1.endsWith(",")) {
            query1 = query1.substring(0, query1.length() - 1);
        }
        query1 += ")";
        System.out.println(query1);
        preparedStatement = connection.prepareStatement(query1);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
    }

    public void delete(Object t,int id) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name();//.equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();
        query = "delete " + TableName + " where ";
        Field[] fields = t.getClass().getDeclaredFields();//fieldhaye class
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();//annnothaye class
            for (Annotation annotation : annotations) {
                if (annotation instanceof Id) {
                    Column c=field.getAnnotation(Column.class);
                    query+=c.name();
                }
            }
        }
        query+="=";
        preparedStatement = connection.prepareStatement(query+String.valueOf(id) +";");
        preparedStatement.executeUpdate();
    }
    public void insert(Object t) throws Exception {
        String s=null;
        List<Object> fieldList = new ArrayList<>();
        connection = DBConnection.getInstance().getConnection();
        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name();//.equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();
        query = "insert into " + TableName + " values( ";
        Field[] fields = t.getClass().getDeclaredFields();
        for (Object obj:fieldList) {
            query += obj + ", ";
        }
        s=s.substring(0,s.length()-2);
        s+=")";
        preparedStatement = connection.prepareStatement(query +";");
        preparedStatement.executeUpdate();
    }
    public void update(Object t,int id) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        List<Object> fieldList = new ArrayList<>();
        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name();//.equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();
        Field[] fields = t.getClass().getDeclaredFields();
//        selectById(p,t);

        for (Object obj:fieldList) {
            query = "update " + TableName + " set "+obj;

        }

        preparedStatement = connection.prepareStatement(query +";");
        preparedStatement.executeUpdate();
    }
    public void selectAll(Object t) throws Exception {
        String s = null;
        connection = DBConnection.getInstance().getConnection();
        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name();//.equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();
        query = "select * from " + TableName ;
        preparedStatement = connection.prepareStatement(query +";");
        preparedStatement.executeUpdate();
    }
    public void selectById(Object t,int id) throws Exception {
        String s = null;
        connection = DBConnection.getInstance().getConnection();
        String TableName = t.getClass().getDeclaredAnnotation(Table.class).name();//.equals("") ? t.getClass().getSimpleName() : t.getClass().getDeclaredAnnotation(Table.class).name();
        query = "select * from " + TableName+" where id="+id ;
        preparedStatement = connection.prepareStatement(query +";");
        preparedStatement.executeUpdate();
    }

}
