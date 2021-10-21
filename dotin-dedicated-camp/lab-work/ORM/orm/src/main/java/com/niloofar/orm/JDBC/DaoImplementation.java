package com.niloofar.orm.JDBC;

import com.niloofar.orm.model.Person;
import com.niloofar.orm.persistence.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class DaoImplementation implements MyDao {
    static Connection connection = JDBCSingleton.getConnection();


    @Override
    public void creat(Object o) throws SQLException {

        PreparedStatement ps = null;
        StringBuilder query = new StringBuilder();
        Table table = o.getClass().getDeclaredAnnotation(Table.class);
        query.append("CREATE TABLE IF NOT EXISTS  " + table.name() + " (");
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Coloumn) {
                    Coloumn coloumn = field.getAnnotation(Coloumn.class);
                    query.append(coloumn.name() + " " + coloumn.dataType() + "("+coloumn.length() +")" + " " + coloumn.des() + ",");
                }
            }
        }
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Id) {
                    Coloumn column = field.getAnnotation(Coloumn.class);
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
        ps = connection.prepareStatement(query1);
        try {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
    }





    @Override
    public void delete(Object p, int id ) throws SQLException {

        PreparedStatement ps = null;
        Table table = p.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder query1 = new StringBuilder();
        query1.append("DELETE FROM" + " " + table.name() + " " + "WHERE ");
        Field[] fields = p.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Id) {
                    Coloumn column = field.getAnnotation(Coloumn.class);
                    query1.append(column.name());
                }
            }
        }
        query1.append("=");
        String end1 = query1.toString();
        ps = connection.prepareStatement(end1 + "?");
        ps.setString(1, String.valueOf(id));
        System.out.println(ps);
        ps.executeUpdate();
    }

    @Override
    public List getAll(Object p) throws SQLException {

        StringBuilder query3=new StringBuilder();
        List ls = new ArrayList();
        PreparedStatement ps = null;
        Table table = p.getClass().getDeclaredAnnotation(Table.class);
        query3.append( "SELECT * FROM  " + table.name());
        String end= query3.toString();
        ps = connection.prepareStatement(end);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(rs.getString(i) + " ");
            }
            System.out.println();
        }
        return ls;

    }

    @Override
    public void alter(Object p,TableName tableName) throws SQLException {
        PreparedStatement ps = null;
        Table table = p.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder query1 = new StringBuilder();
        query1.append("alter table " + " " + table.name() + " " + "ADD CONSTRAINT ");
        Field[] fields = p.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof ForeignKEY) {
                    Coloumn coloumn = field.getAnnotation(Coloumn.class);
                    query1.append("FOREIGN KEY(" + coloumn.name() + ")");
                }
            }
        }
        query1.append(" references "+tableName);
        String end1 = query1.toString();
        ps = connection.prepareStatement(end1 + "(Id) ON UPDATE CASCADE;");
        System.out.println(ps);
        ps.executeUpdate();
    }



    @Override
    public void update(Object p,int id) throws SQLException {
          PreparedStatement ps = null;
          ArrayList<String> f1 = new ArrayList<>();
          Table table = p.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder query2=new StringBuilder();
        query2.append("UPDATE "+ table.name() + " set ");
        Field[] fields = p.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {

                if (annotation instanceof Coloumn && field.getAnnotation(Id.class) == null) {
                    Coloumn column = field.getAnnotation(Coloumn.class);
                    query2.append(column.name() + " = " + "? " + ",");
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
                if (annotation instanceof Id) {
                    Coloumn column = field.getAnnotation(Coloumn.class);
                    end += column.name();
                }
            }
        }
        ps = connection.prepareStatement( end + "=" + id);
        for (int i = 0; i < f1.size(); i++) {
            ps.setString(i + 1, f1.get(i));
        }
        System.out.println(ps);
      ps.executeUpdate();
    }




    @Override
    public void add(Object o) throws SQLException {
        PreparedStatement ps = null;
        String sql = "";
        List<Object> fieldList = new ArrayList<>();
        Table table = o.getClass().getDeclaredAnnotation(Table.class);
        String query = "insert into " + table.name() + " (";
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation:annotations) {
                if(annotation instanceof Coloumn){
                    Coloumn coloumn = field.getAnnotation(Coloumn.class);
                    query += coloumn.name() + ", " ;
                    try {
                        if(coloumn.dataType().equals("varchar")) {
                            fieldList.add("\'" + field.get(o) + "\'");
                        }else{
                            fieldList.add(field.get(o));
                        }
                    }catch (IllegalAccessException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        query = query.substring(0, query.length()-2);
        query += ") values (";
        for (Object obj:fieldList) {
            query += obj + ", ";
        }
        query = query.substring(0, query.length()-2);
        query += ");";

        System.out.println(query);
        try {
           ps = connection.prepareStatement(query);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    }

