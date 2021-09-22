package com.nebula.phonenumberbook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Statements {

    private Scanner scanner = new Scanner(System.in);
    private Statement statement;
    Person person;


    public Statements() throws SQLException {

        scanner = new Scanner(System.in);
        ConnectionManager.setValue();
        Connection conn = ConnectionManager.getConnection();
        statement = conn.createStatement();
        person = new Person();

    }

    public void addRecord() throws SQLException {

        System.out.print("Please insert the value of id: ");
        int id = scanner.nextInt();

        scanner.nextLine();// to solve next method problem

        System.out.println("Please insert the value of first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please insert the value of last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Please insert the value of phone number: ");
        String phoneNumber = scanner.nextLine();


        person = new Person(id, firstName, lastName, phoneNumber);

        String insertFields = "INSERT INTO persons (id, firstname, lastname, phone_number) VALUES (";
        String insertValues = person.getId() + ",'" + person.getFirstName() + "','" + person.getLastName() + "','" + person.getPhoneNumber() + "')";

        String addRecordQuery = insertFields + insertValues;

        statement.executeUpdate(addRecordQuery);

        System.out.printf("record %d added\n", person.getId());

    }

    public void deleteRecord() throws SQLException {

        System.out.print("please insert the number of record that you want to delete: ");
        int rowNumber = scanner.nextInt();

        String deleteRecordQuery = "delete from persons where id = " + rowNumber;

        int deleted = statement.executeUpdate(deleteRecordQuery);
        System.out.printf("record %d deleted\n", rowNumber);


    }

    public void showRecord() throws SQLException {

        System.out.println("Please insert the number of record that you want to display");
        int rowNumber = scanner.nextInt();

        String showRecordQuery = "select id, firstname, lastname, phone_number from phonebook.persons where id = " + rowNumber;
        ResultSet resultSet = statement.executeQuery(showRecordQuery);

        while (resultSet.next()) {

            System.out.println(resultSet.getInt(1) + " " +
                    resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4));
        }

    }

    public void updateRecord() throws SQLException {

        System.out.println("Please insert the number of record that you want to update: ");
        int rowNumber = scanner.nextInt();

        System.out.print("Please insert the value of first name: ");
        String firstName = scanner.nextLine();
        person.setFirstName(firstName);

        scanner.nextLine(); // to solve next method problem

        System.out.print("Please insert the value of last name: ");
        String lastname = scanner.nextLine();
        person.setLastName(lastname);

        System.out.print("Please insert the value of phone number: ");
        String phone_number = scanner.nextLine();
        person.setPhoneNumber(phone_number);

        String updateRecordQuery = "UPDATE phonebook.persons SET firstname = " + "'" + person.getFirstName() + "'" + ", lastname = " + "'" + person.getLastName()
                + "'" + ",phone_number = " + "'" + person.getPhoneNumber() + "'" + " where id = " + rowNumber;

        int deleted = statement.executeUpdate(updateRecordQuery);
        System.out.printf("record %d updated\n", rowNumber);

    }

}
