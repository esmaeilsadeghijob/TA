package com.mapsa.phonebook.database;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JDBCImplement implements JDBC<String> {
    private static String tableName = "phonebook";
    private static String query;

    //if(phone number doesn't exist){
    //  creates a new row
    //}else{
    //  out(The phone number already exists in the phonebook)
    //}
    @Override
    public void create(String phone, String fullName) {
        query = "select exists (select phonenumber from " + tableName + " where phonenumber = '" + phone + "')";
        System.out.println("The query is: " + query);//TODO log
        PreparedStatement statement = connecting(query);//calling method "connecting" to connect and return the statement
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                if (resultSet.getString(1).equals("0")) { //if the phone number doesn't exist in the phonebook
                    query = "insert into " + tableName + "(fullname, phonenumber) values('" + fullName + "','" + phone + "');";
                    System.out.println("The query is: " + query);//TODO log
                    PreparedStatement statement2 = connecting(query);
                    statement2.execute();
                    System.out.printf("%nNew person '%s' has been added to the phonebook.%n%n", fullName);
                } else {
                    System.out.printf("The number you entered is already in the phonebook.%n%n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //if(name exists){
    //  out(The name and the corresponding phone number)
    //}else{
    //  out(The name doesn't exist in the phonebook)
    //}
    @Override
    public void readByName(String fullName) {
        query = "select exists (select fullname from " + tableName + " where fullname = '" + fullName + "');";
        System.out.println("The query is: " + query);//TODO log
        PreparedStatement statement = connecting(query);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                if (resultSet.getString(1).equals("1")) { //if the name exists in the phonebook
                    query = "select phonenumber from " + tableName + " where fullname = '" + fullName + "';";
                    System.out.println("The query is: " + query);//TODO log
                    PreparedStatement statement2 = connecting(query);
                    ResultSet resultSet2 = statement2.executeQuery(query);
                    if (resultSet2.next()) {
                        System.out.printf("The number for the name '%s' is:%n%s%n%n", fullName, resultSet2.getString("phonenumber"));
                    }
                } else {
                    System.out.printf("The name doesn't exist in the phonebook.%n%n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //if(phone number exists){
    //  out(The phone number and the corresponding name)
    //}else{
    //  out(The phone number doesn't exist in the phonebook)
    //}
    @Override
    public void readByPhoneNumber(String phoneNumber) {
        query = "select exists (select phonenumber from " + tableName + " where phonenumber = '" + phoneNumber + "');";
        System.out.println("The query is: " + query);//TODO log
        PreparedStatement statement = connecting(query);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                if (resultSet.getString(1).equals("1")) { //if the phone number exists in the phonebook
                    query = "select fullname from " + tableName + " where phonenumber = '" + phoneNumber + "';";
                    System.out.println("The query is: " + query);//TODO log
                    PreparedStatement statement2 = connecting(query);
                    ResultSet resultSet2 = statement2.executeQuery(query);
                    if (resultSet2.next()) {
                        System.out.printf("The number '%s' is for:%n%s%n%n", phoneNumber, resultSet2.getString("fullname"));
                    }
                } else {
                    System.out.printf("The phone number doesn't exist in the phonebook.%n%n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //if(phone number exists){
    //  if(full name for the phone number exists){
    //      out(The information already exists in the phonebook)
    //  }else{
    //      updates the name for the phone number
    //  }
    //}else{
    //  if(full name exists){
    //      updates the phone number for the name
    //  }else{
    //      out(both phone number and name are new. Please add them to the phonebook before trying to update)
    //  }
    //}
    @Override
    public void update(String phoneNumber, String fullName) {
        query = "select exists (select phonenumber from " + tableName + " where phonenumber = '" + phoneNumber + "');";
        System.out.println("The query is: " + query);//TODO log
        PreparedStatement statement = connecting(query);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                if (resultSet.getString(1).equals("1")) { //if the phone number exists in the phonebook
                    query = "select fullname from " + tableName + " where phonenumber = '" + phoneNumber + "';";
                    System.out.println("The query is: " + query);//TODO log
                    PreparedStatement statement2 = connecting(query);
                    ResultSet resultSet2 = statement2.executeQuery(query);
                    if (resultSet2.next()) {
                        if (resultSet2.getString("fullname").equals(fullName)) { //if the name for the existing phone number exists
                            System.out.printf("The information already exist in the phonebook.%n%n");
                        } else {
                            query = "update " + tableName + " set fullname = '" + fullName + "' where phonenumber = '" + phoneNumber + "';";
                            System.out.println("The query is: " + query);//TODO log
                            PreparedStatement statement3 = connecting(query);
                            statement3.execute();
                            System.out.printf("The name for the number '%s' has been updated to:%n%s%n%n", phoneNumber, fullName);
                        }
                    }
                }else{ //if the phone number doesn't exist
                    query = "select exists (select fullname from " + tableName + " where fullname = '" + fullName + "');";
                    System.out.println("The query is: " + query);//TODO log
                    PreparedStatement statement4 = connecting(query);
                    ResultSet resultSet3 = statement4.executeQuery(query);
                    if (resultSet3.next()) {
                        if (resultSet3.getString(1).equals("1")) { //if the name exists in the phonebook
                            query = "update " + tableName + " set phonenumber = '" + phoneNumber + "' where fullname = '" + fullName + "';";
                            System.out.println("The query is: " + query);//TODO log
                            PreparedStatement statement5 = connecting(query);
                            statement5.execute();
                            System.out.printf("The number for the name %s has been updated to:%n%s%n%n", fullName, phoneNumber);
                        } else { //if the name doesn't exist in the phonebook
                            System.out.println("Both phone number and full name are new. Please add them to the phonebook before trying to update.");
                        }
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //if(phone number exists){
    //  deletes the phone number and the corresponding name
    //  out(The phone number has been deleted)
    //}else{
    //  out(The phone number doesn't exist in the phonebook)
    //}
    @Override
    public void deleteByPhoneNumber(String phoneNumber) {
        query = "select exists (select phonenumber from " + tableName + " where phonenumber = '" + phoneNumber + "');";
        System.out.println("The query is: " + query);//TODO log
        PreparedStatement statement = connecting(query);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                if (resultSet.getString(1).equals("1")) { //if the phone number exists in the phonebook
                    query = "delete from " + tableName + " where phonenumber = '" + phoneNumber + "';";
                    System.out.println("The query is: " + query);//TODO log
                    PreparedStatement statement2 = connecting(query);
                    statement2.execute();
                    System.out.printf("The number '%s' has been deleted.%n%n", phoneNumber);
                } else {
                    System.out.printf("The phone number doesn't exist in the phonebook.%n%n");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //if(name exists){
    //  deletes the name and the corresponding phone number
    //  out(The name has been deleted)
    //}else{
    //  out(The name doesn't exist in the phonebook)
    //}
    @Override
    public void deleteByName(String fullName) {
        query = "select exists (select fullname from " + tableName + " where fullname = '" + fullName + "');";
        System.out.println("The query is: " + query);//TODO log
        PreparedStatement statement = connecting(query);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                if (resultSet.getString(1).equals("1")) { //if the name exists in the phonebook
                    query = "delete from " + tableName + " where fullname = '" + fullName + "';";
                    System.out.println("The query is: " + query);//TODO log
                    PreparedStatement statement2 = connecting(query);
                    statement2.execute();
                        System.out.printf("The name '%s' has been deleted.%n%n", fullName);
                } else {
                    System.out.printf("The name doesn't exist in the phonebook.%n%n");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Adds all the rows in the phonebook to a map and returns it
    @Override
    public Map<String,String> getAll(){
        Map<String,String> map = new HashMap<>();
        query = "select * from " + tableName;
        System.out.println("The query is: " + query);//TODO log
        PreparedStatement statement = connecting(query);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                String phoneNumbers = resultSet.getString("phonenumber");
                String fullNames = resultSet.getString("fullname");
                map.put(phoneNumbers,fullNames);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return map;
    }

    //Gets a connection from dbConnection object and returns a PreparedStatement with a query that has been passed to it
    public PreparedStatement connecting(String query) {
        DBConnection dbConnection = DBConnection.getInstance();
        PreparedStatement statement = null;
        try {
            Connection connection = dbConnection.getConnection();
            statement = connection.prepareStatement(query);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
