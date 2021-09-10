package com.mapsa.phoneBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FatemehJdbcCrud implements JdbcCrud<Subscriber> {

    private final static Logger logger = LoggerFactory.getLogger(FatemehJdbcCrud.class);
    public Connection connection;
    public Statement statement;
    public String sql;
    public String text;

    @Override
    public boolean save(Subscriber subscriber) throws SQLException {
        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        Subscriber existsSubscriber  = findByPhone(subscriber);

        if (existsSubscriber.getId() > 0 ){
            return false;
        }

        sql = "insert into subscriber(id,first_name,last_name,phone_number) values (" + subscriber.getId() + ",'" + subscriber.getName() + "','" + subscriber.getFamily() + "','" + subscriber.getPhone() + "')";
        statement.executeUpdate(sql);
        text = "save";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
        
        return true;
    }

    @Override
    public void updateSubscriberInfo(Subscriber subscriber) throws SQLException {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        sql = "update subscriber set first_name='" + subscriber.getName() + "' , last_name='" + subscriber.getFamily() + "' where phone_number='" + subscriber.getPhone() + "'";
        System.out.println(sql);
        statement.executeUpdate(sql);
        text = "updateSubscriberInfo";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
    }

    @Override
    public boolean updateSubscriberPhone(Subscriber subscriber, String oldPhoneNumber) throws SQLException {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        Subscriber existsSubscriber  = findByPhone(subscriber);

        if (existsSubscriber.getId() > 0 ){
            return false;
        }

        sql = "update subscriber set phone_number='" + subscriber.getPhone() + "' where phone_number = '" +oldPhoneNumber+ "'";
        System.out.println(sql);
        statement.executeUpdate(sql);
        text = "updateSubscriberPhone";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);

        return true;
    }

    @Override
    public void delete(Subscriber subscriber) throws SQLException {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        sql = "delete from subscriber where phone_number='" + subscriber.getPhone() + "'";
        statement.executeUpdate(sql);
        text = "delete";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
    }

    @Override
    public List<Subscriber> findAll() throws SQLException {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        sql = "select * from subscriber";
        ResultSet resultSet = statement.executeQuery(sql);

        List<Subscriber> subscriberList = new ArrayList<>();

        while (resultSet.next()) {
            Subscriber subscriber = new Subscriber();
            subscriber.setId(resultSet.getLong("id"));
            subscriber.setName(resultSet.getString("first_name"));
            subscriber.setFamily(resultSet.getString("last_name"));
            subscriber.setPhone(resultSet.getString("phone_number"));
            subscriberList.add(subscriber);
        }
        text = "findAll";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
        return subscriberList;
    }

    @Override
    public Subscriber findByPhone(Subscriber subscriber) throws SQLException {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        sql = "select * from subscriber where phone_number='" + subscriber.getPhone() + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            subscriber.setId(resultSet.getLong("id"));
            subscriber.setName(resultSet.getString("first_name"));
            subscriber.setFamily(resultSet.getString("last_name"));
            subscriber.setPhone(resultSet.getString("phone_number"));
        }

        text = "findByPhone";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
        return subscriber;

    }

    @Override
    public List<Subscriber> findByNameAndFamily(Subscriber subscriber) throws SQLException {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        sql = "select * from subscriber where upper(first_name) like '%" + subscriber.getName().toUpperCase() + "%' and upper(last_name) like '%" + subscriber.getFamily().toUpperCase() + "%'";
        ResultSet resultSet = statement.executeQuery(sql);

        List<Subscriber> subscriberList = new ArrayList<>();
        while (resultSet.next()) {
            Subscriber subscriber1 = new Subscriber();
            subscriber1.setId(resultSet.getLong("id"));
            subscriber1.setName(resultSet.getString("first_name"));
            subscriber1.setFamily(resultSet.getString("last_name"));
            subscriber1.setPhone(resultSet.getString("phone_number"));
            subscriberList.add(subscriber1);
        }
        text = "findByNameAndFamily";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
        return subscriberList;
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }
}
