package com.mapsa.application;

import com.mapsa.module.PhoneBook;

import java.sql.*;

public class SQLTest {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        while (true) {
            int op = phoneBook.getMenuOp();
            try {
                switch (op) {
                    case 1:
                        phoneBook.addNewContact();
                        break;
                    case 2:
                        phoneBook.addPhoneNumber();
                        break;
                    case 3:
                        phoneBook.editContact();
                        break;
                    case 4:
                        phoneBook.editPhoneNumber();
                        break;
                    case 5:
                        phoneBook.showContactInfo();
                        break;
                    case 6:
                        phoneBook.showAllContacts();
                        break;
                    case 7:
                        phoneBook.deleteContact();
                        break;
                    case 8:
                        phoneBook.deletePhone();
                        break;
                    case 9:
                    default:
                        return;
                }
            } catch (SQLException E) {
                System.out.println("something wrong. try again!");
            }
        }
    }

}
