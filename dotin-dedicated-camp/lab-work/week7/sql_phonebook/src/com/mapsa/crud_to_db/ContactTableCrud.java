package com.mapsa.crud_to_db;

import com.mapsa.db_connection.ConnectionToDB;
import com.mapsa.module.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactTableCrud implements JdbcCrud<Contact, Integer> {
    private final Connection connection;
    private final Statement statement;
    private PreparedStatement pstmt;

    public ContactTableCrud() {
        ConnectionToDB ctd = ConnectionToDB.getInstance();
        connection = ctd.getConnection();
        statement = ctd.getStatement();
    }

    @Override
    public void save(Contact contact) throws SQLException {
        String query = "insert into Contact (id, firstName, lastName) " +
                " values (?, ?, ?)";
        pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, contact.getId());
        pstmt.setString(2, contact.getFirstname());
        pstmt.setString(3, contact.getLastname());
        pstmt.executeUpdate();
    }

    @Override
    public void update(Contact contact) throws SQLException {
        String query = "update Contact set id = ?, firstName = ?, lastName = ? " +
                "where id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, contact.getId());
        pstmt.setString(2, contact.getFirstname());
        pstmt.setString(3, contact.getLastname());
        pstmt.setInt(4, contact.getLastId());
        pstmt.executeUpdate();
    }

    @Override
    public List<Contact> findAll() throws SQLException {
        String query = "select * from Contact";
        List<Contact> contacts = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            contacts.add(new Contact(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3)));
        }
        return contacts;
    }

    @Override
    public Contact findById(Integer id) throws SQLException {
        String query = "select * from Contact where id = " + id;
        Contact contact = null;
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            contact = new Contact(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3));
        }
        return contact;
    }


    @Override
    public void delete(Contact contact) throws SQLException {
        String query = "delete from Contact where id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, contact.getId());
        pstmt.executeUpdate();
    }
}
