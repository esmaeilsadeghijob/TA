package com.mapsa.crud_to_db;

import com.mapsa.db_connection.ConnectionToDB;
import com.mapsa.module.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneTableCrud implements JdbcCrud<Phone, String> {
    private final Connection connection;
    private final Statement statement;
    private PreparedStatement pstmt;

    public PhoneTableCrud() {
        ConnectionToDB ctd = ConnectionToDB.getInstance();
        connection = ctd.getConnection();
        statement = ctd.getStatement();
    }

    @Override
    public void save(Phone phone) throws SQLException {
        String query = "insert into Phone (contact_id, phoneNumber) " +
                " values (?, ?)";
        pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, phone.getContactId());
        pstmt.setString(2, phone.getPhoneNumber());
        pstmt.executeUpdate();
    }

    @Override
    public void update(Phone phone) throws SQLException {
        String query = "update Phone set contact_id = ?, phoneNumber = ? " +
                "where phoneNumber = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, phone.getContactId());
        pstmt.setString(2, phone.getPhoneNumber());
        pstmt.setString(3, phone.getLastPhoneNumber());
        pstmt.executeUpdate();
    }

    @Override
    public List<Phone> findAll() throws SQLException {
        String query = "select * from Phone";
        List<Phone> phones = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            phones.add(new Phone(resultSet.getInt(1), resultSet.getString(2)));
        }
        return phones;
    }

    public List<Phone> findAll(int contactId) throws SQLException {
        String query = "select * from Phone where contact_id = " + contactId;
        List<Phone> phones = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            phones.add(new Phone(resultSet.getInt(1), resultSet.getString(2)));
        }
        return phones;
    }

    @Override
    public Phone findById(String phoneNumber) throws SQLException {
        java.lang.String query = "select * from Phone where phoneNumber = \'" + phoneNumber + "\'";
        Phone phone = null;
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            phone = new Phone(resultSet.getInt(1), resultSet.getString(2));
        }
        return phone;
    }

    @Override
    public void delete(Phone phone) throws SQLException {
        String query = "delete from Phone where phoneNumber = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, phone.getPhoneNumber());
        pstmt.executeUpdate();
    }
}
