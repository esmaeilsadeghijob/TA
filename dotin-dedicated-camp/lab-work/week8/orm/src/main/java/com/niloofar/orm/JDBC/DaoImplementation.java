package com.niloofar.orm.JDBC;

import com.niloofar.orm.model.Person;
import com.niloofar.orm.persistence.Coloumn;
import com.niloofar.orm.persistence.Id;
import com.niloofar.orm.persistence.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class DaoImplementation implements MyDao{
    static Connection connection=JDBCSingleton.getConnection();


    @Override
    public void creat(Object o) throws SQLException {

        PreparedStatement ps = null;
        StringBuilder query=new StringBuilder();
        Table table = o.getClass().getDeclaredAnnotation(Table.class);
        query.append("CREATE TABLE " + table.name() + " (");
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Coloumn) {
                    Coloumn coloumn = field.getAnnotation(Coloumn.class);
                    query.append(coloumn.name() + " " + coloumn.dataType() + "(" + coloumn.length() + "),");
                }
            }
        }
        String  query1= query.toString();
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
    public int add(Person p) throws SQLException {
        PreparedStatement ps = null;
        Table table = p.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder query=new StringBuilder();
           query.append("INSERT INTO "+ table.name() + "(");
            Field[] fields = p.getClass().getDeclaredFields();
            for (Field field : fields) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Coloumn) {
                        Coloumn column = field.getAnnotation(Coloumn.class);
                        query.append(column.name() + ",");
                    }
                }
            }
            String end= query.toString();
            if (end.endsWith(",")) {
          end= end.substring(0, query.length() - 1);
            }

         ps = connection.prepareStatement( end += ") VALUES (?,?)");
         ps.setString(1, String.valueOf(p.getId()));
         ps.setString(2, p.getName());
         System.out.println(ps);
        int n = ps.executeUpdate();
        return n;

    }


    @Override
    public void delete(Person p,int id) throws SQLException {

        PreparedStatement ps = null;
        Table table = p.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder query1 = new StringBuilder();
        query1.append("DELETE FROM" + " "+ table.name() +" " + "WHERE ");
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
        ps = connection.prepareStatement(end1 +"?");
        ps.setString(1, String.valueOf(id));
        System.out.println(ps);
       ps.executeUpdate();
    }



    @Override
    public void update(Person p,int id) throws SQLException {
        PreparedStatement ps = null;
        Table table = p.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder query2=new StringBuilder();
        query2.append("UPDATE "+ table.name() + " set ");
        Field[] fields = p.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {

                if (annotation instanceof Coloumn ) {
                    Coloumn column = field.getAnnotation(Coloumn.class);
                    query2.append(column.name() + " = " + "? " + ",");
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

        ps = connection.prepareStatement( end += "= ?");
        ps.setString(1, String.valueOf(p.getId()));
        ps.setString(2, p.getName());
        ps.setString(3, String.valueOf(id));

        System.out.println(ps);
      ps.executeUpdate();

    }

    @Override
    public List<Person> getAll(Person p) throws SQLException {

        StringBuilder query3=new StringBuilder();
        PreparedStatement ps = null;

        Table table = p.getClass().getDeclaredAnnotation(Table.class);
        query3.append( "SELECT * FROM  " + table.name());
        String end= query3.toString();
         ps = connection.prepareStatement(end);
        ResultSet rs = ps.executeQuery();
        List<Person> ls = new ArrayList();
        System.out.println(query3);
        while (rs.next()) {
            Person np=new Person();
           np.setId(rs.getInt("id"));
         np.setName(rs.getString("name"));
            ls.add(np);
            System.out.println(rs.getString(1) + "     " +
                    rs.getString(2) + "     ");
        }
        return ls;


    }


}
