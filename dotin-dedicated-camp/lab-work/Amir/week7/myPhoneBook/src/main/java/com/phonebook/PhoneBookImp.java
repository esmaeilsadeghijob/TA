package com.phonebook;

import com.phonebook.database.ConnectionDB;
import com.phonebook.PhoneBook;
import com.phonebook.database.ConnectionDB2;

import java.sql.*;
import java.util.Scanner;

public class PhoneBookImp {

    private Scanner scanner = new Scanner(System.in);
    private Statement statement;
    PhoneBook phoneBook;

    public PhoneBookImp() throws SQLException {

        scanner = new Scanner(System.in);
//        ConnectionDB.readConfig();
//        ConnectionDB2.getConnection();
        Connection connection = ConnectionDB2.getConnection();
        statement = connection.createStatement();
        phoneBook = new PhoneBook();

    }


    public void addOne() {


        System.out.print("Please enter the id: ");
        int id = scanner.nextInt();

        scanner.nextLine();// to solve next method problem


        System.out.print("Please enter your name : ");
        String name = scanner.nextLine();


        System.out.println("Please enter your phone number : ");
        String phoneNumber = scanner.nextLine();


        phoneBook = new PhoneBook(name, phoneNumber, id);

        String insertFields = "INSERT INTO users (id, fullname,phonenumber) VALUES (";
        String insertValues = phoneBook.getId() + ",'" + phoneBook.getName() + "','" + phoneBook.getPhoneNumber() + "')";

        String addRecordQuery = insertFields + insertValues;

        try {
            statement.executeUpdate(addRecordQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.printf("record %d added\n", phoneBook.getId());
    }
    
    



    public void deleteOne() throws SQLException {

            System.out.println("please enter the number of person that you want to delete : ");
            int rowNumber = scanner.nextInt();

            String deleteRecordQuery = "delete from users where id = " + rowNumber;

            int deleted = statement.executeUpdate(deleteRecordQuery);
            System.out.printf("record %d deleted\n", rowNumber);
            
    }



    public void updateOnePhoneBook() throws SQLException {


            System.out.println("which number do you want to update ? : ");
            int rowNumber = scanner.nextInt();

            System.out.print("Please enter the name : ");
            String name = scanner.nextLine();
            phoneBook.setName(name);

            scanner.nextLine(); // to solve next method problem

            System.out.print("Please enter the phone number : ");
            String phoneNumber = scanner.nextLine();
            phoneBook.setPhoneNumber(phoneNumber);

            String updateRecordQuery = "UPDATE phonebook.users SET fullname = " + "'" + phoneBook.getName() +
                    "'" + ",phone_number = " + "'" + phoneBook.getPhoneNumber() + "'" + " where id = " + rowNumber;

            int deleted = statement.executeUpdate(updateRecordQuery);
            System.out.printf("record %d updated\n", rowNumber);

        }

        public void showUser() throws SQLException {
            System.out.println("Please enter the number of record that you want to show :");
            int rowNumber = scanner.nextInt();

            String showUserQuery = "select id, fullname, phonenumber from phonebook.users where id = " + rowNumber;
            ResultSet resultSet = statement.executeQuery(showUserQuery);

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+ " *** " + resultSet.getString(2) + " *** " + resultSet.getString(3));
            }
        }


}
