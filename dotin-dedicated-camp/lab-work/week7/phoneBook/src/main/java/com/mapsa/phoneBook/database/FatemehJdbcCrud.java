package com.mapsa.phoneBook.database;

import com.mapsa.phoneBook.model.Phone;
import com.mapsa.phoneBook.model.PhoneType;
import com.mapsa.phoneBook.model.Subscriber;
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
    public String save(Subscriber subscriber) throws Exception {
        connection = ConnectionToDB.getInstance().getConnection();
        connection.setAutoCommit(false);
        statement = connection.createStatement();

        String dupPhoneNo  = checkPhoneNumbers(subscriber.getPhone());

        if (!dupPhoneNo.equals("")){
            return dupPhoneNo;
        }
        subscriber.setId(getNextSequenceValue());

        sql = "insert into subscriber(id,name,family) values (" + subscriber.getId() + ",'" + subscriber.getName() + "','" + subscriber.getFamily() + "')";
        int row = statement.executeUpdate(sql);

        if (row > 0) {
            for (Phone phone : subscriber.getPhone()) {
                phone.setId(getNextSequenceValue());
                sql = "insert into phone(id,phone_number,phone_type,subs_id) values (" + phone.getId() + ",'" + phone.getNumber() + "','" + phone.getPhoneType().name() + "'," + subscriber.getId() +")";
                statement.executeUpdate(sql);
            }
        }

        text = "save";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
        
        return "";
    }

    @Override
    public void updateSubscriberInfo(Subscriber subscriber) throws Exception {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        sql = "select * from phone where phone_number='" + subscriber.getPhone().get(0).getNumber() + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            sql = "update subscriber set name='" + subscriber.getName() + "' , family='" + subscriber.getFamily() + "' where id =" + resultSet.getString("subs_id");
            statement.executeUpdate(sql);
        }

        text = "updateSubscriberInfo";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
    }

    @Override
    public String updateSubscriberPhone(Subscriber subscriber, String oldPhoneNumber) throws Exception {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        String dupPhoneNo  = checkPhoneNumbers(subscriber.getPhone());

        if (!dupPhoneNo.equals("")){
            return dupPhoneNo;
        }

        sql = "update phone set phone_number='" + subscriber.getPhone().get(0).getNumber() + "' where phone_number = '" +oldPhoneNumber+ "'";
        System.out.println(sql);
        statement.executeUpdate(sql);
        text = "updateSubscriberPhone";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);

        return "";
    }

    @Override
    public void delete(Subscriber subscriber) throws SQLException {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        sql = "delete from phone where phone_number='" + subscriber.getPhone().get(0).getNumber() + "'";
        statement.executeUpdate(sql);

        text = "delete";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
    }

    @Override
    public List<Subscriber> findAll() throws Exception {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        sql = "select * from subscriber";
        ResultSet resultSet = statement.executeQuery(sql);

        List<Subscriber> subscriberList = new ArrayList<>();

        while (resultSet.next()) {
            Subscriber subscriber = new Subscriber();
            subscriber.setId(resultSet.getLong("id"));
            subscriber.setName(resultSet.getString("name"));
            subscriber.setFamily(resultSet.getString("family"));
            subscriber.setPhone(getSubscriberPhones(subscriber.getId()));
            subscriberList.add(subscriber);
        }
        text = "findAll";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
        return subscriberList;
    }

    @Override
    public Subscriber findByPhone(Subscriber subscriber) throws Exception {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        sql = "select * from phone where phone_number='" + subscriber.getPhone().get(0).getNumber() + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            sql = "select * from subscriber where id ='" + resultSet.getString("subs_id") + "'";
             resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                subscriber.setId(resultSet.getLong("id"));
                subscriber.setName(resultSet.getString("name"));
                subscriber.setFamily(resultSet.getString("family"));
                subscriber.setPhone(getSubscriberPhones(subscriber.getId()));
            }
        }
        text = "findByPhone";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
        return subscriber;
    }

    @Override
    public List<Subscriber> findByNameAndFamily(Subscriber subscriber) throws Exception {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        sql = "select * from subscriber where upper(name) like '%" + subscriber.getName().toUpperCase() + "%' and upper(family) like '%" + subscriber.getFamily().toUpperCase() + "%'";
        ResultSet resultSet = statement.executeQuery(sql);

        List<Subscriber> subscriberList = new ArrayList<>();
        while (resultSet.next()) {
            Subscriber subscriber1 = new Subscriber();
            subscriber1.setId(resultSet.getLong("id"));
            subscriber1.setName(resultSet.getString("name"));
            subscriber1.setFamily(resultSet.getString("family"));
            subscriber1.setPhone(getSubscriberPhones(subscriber1.getId()));
            subscriberList.add(subscriber1);
        }
        text = "findByNameAndFamily";
        logger.info("Class Name: {} , {} ... ", FatemehJdbcCrud.class.getSimpleName(), text);
        return subscriberList;
    }

    public String checkPhoneNumbers(List<Phone> phoneList) throws Exception {

        connection = ConnectionToDB.getInstance().getConnection();
        statement = connection.createStatement();

        for (Phone phone : phoneList) {
            sql = "select * from phone where phone_number='" + phone.getNumber() + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return resultSet.getString("phone_number");
            }
        }
        return "";
    }

    public List<Phone> getSubscriberPhones(long subsId) throws Exception{

        String sql = "select * from phone where subs_id = " + subsId;
        ResultSet resultSet = statement.executeQuery(sql);
        List<Phone> phoneList = new ArrayList<>();

        while(resultSet.next()) {
            Phone phone = new Phone();
            phone.setId(resultSet.getLong("id"));
            phone.setNumber(resultSet.getString("phone_number"));
            phone.setPhoneType(PhoneType.valueOf(resultSet.getString("phone_type")));
            phone.setSubsId(resultSet.getLong("subs_id"));
            phoneList.add(phone);
        }
        return phoneList;
    }

    public long getNextSequenceValue() throws Exception{
        String sql = "select phoneBook_seq.nextval ssq from dual";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        return resultSet.getLong("ssq");
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }
}
