package com.phonebook;

import java.sql.SQLException;
import java.util.Scanner;

public class Console {

    public void showMenu() {
        System.out.println("----- phone book -----");
        System.out.println("1-> Add user");
        System.out.println("2-> Delete user");
        System.out.println("3-> Update user");
        System.out.println("4-> Show user");
        System.out.println("5-> Quit");
        System.out.println("you can choose an action by entering number");

    }

    public void userChoice() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        PhoneBookImp phoneBookDaoImp = new PhoneBookImp();

        byte userInput = scanner.nextByte();

        if (userInput > 0 && userInput < 6) {

            switch (userInput) {
                case 1:
                    phoneBookDaoImp.addOne();
                    break;
                case 2:
                    phoneBookDaoImp.deleteOne();
                    break;
                case 3:
                    phoneBookDaoImp.updateOnePhoneBook();
                    break;
                case 4:
                    phoneBookDaoImp.showUser();
                    break;
                case 5:
                    System.out.println("Hope u come back soon :-)");
                    break;

            }

        } else {
            throw new IllegalArgumentException("Invalid input !! ***** please enter a valid number.");
        }
    }

}
