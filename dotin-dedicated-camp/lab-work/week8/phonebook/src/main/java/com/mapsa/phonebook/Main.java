package com.mapsa.phonebook;

import com.mapsa.phonebook.database.JDBCImplement;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private final static JDBCImplement jdbcImplement = new JDBCImplement();
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Welcome to maryam's phonebook.");
        int userChoice = entry();
        crudInvocation(userChoice);
    }

    //Displays the options for the user and returns the number that the user chose
    public static int entry() {
        int i = 6;
        System.out.printf("Please enter a number:%n" +
                "1) enter a new person into phonebook.%n" +
                "2) find a person in phonebook.%n" +
                "3) change an existing person information in phonebook.%n" +
                "4) delete a person from the phonebook.%n" +
                "5) see all the phonebook.%n" +
                "6) exit the program.%n");

        try {
            scanner = new Scanner(System.in);
            do {
                i = Integer.parseInt(scanner.nextLine());
            } while ((i < 1) || (i > 6));
        } catch (NoSuchElementException e) {
            System.err.println("Invalid input.");
        }
        return i;
    }

    //Based on the user choice invokes one of the JDBCImplement methods
    public static void crudInvocation(int userChoice) {
        int j = 3;
        while (userChoice != 6) {
            switch (userChoice) {
                case 1:
                    System.out.printf("%nPlease enter the phone number:%n");
                    String number = scanner.nextLine();
                    System.out.println("Please enter the full name:");
                    String fullName = scanner.nextLine();
                    jdbcImplement.create(number, fullName);
                    break;
                case 2:
                    System.out.printf("%nPlease enter a number. How do you want to find the person:%n" +
                            "1) by name.%n" +
                            "2) by phone number.%n");
                    try {
                        do {
                            j = scanner.nextInt();
                        } while ((j < 1) || (j > 2));
                    } catch (NoSuchElementException e) {
                        System.err.println("Invalid input.");
                    }
                    switch (j) {
                        case 1:
                            System.out.printf("%nPlease enter the full name:%n");
                            scanner.nextLine();
                            String findByName = scanner.nextLine();
                            jdbcImplement.readByName(findByName);
                            break;
                        case 2:
                            System.out.printf("%nPlease enter the phone number:%n");
                            scanner.nextLine();
                            String findByNumber = scanner.nextLine();
                            jdbcImplement.readByPhoneNumber(findByNumber);
                            break;
                    }
                    break;
                case 3:
                    System.out.printf("%nPlease enter the phone number:%n");
                    String changingNumber = scanner.nextLine();
                    System.out.println("Please enter the full name:");
                    String changingName = scanner.nextLine();
                    jdbcImplement.update(changingNumber, changingName);
                    break;
                case 4:
                    System.out.printf("%nPlease enter a number. How do you want to delete the person:%n" +
                            "1) by name.%n" +
                            "2) by phone number.%n");
                    try {
                        do {
                            j = scanner.nextInt();
                        } while ((j < 1) || (j > 2));
                    } catch (NoSuchElementException e) {
                        System.err.println("Invalid input.");
                    }
                    switch (j) {
                        case 1:
                            System.out.printf("%nPlease enter the full name:%n");
                            scanner.nextLine();
                            String deleteByName = scanner.nextLine();
                            jdbcImplement.deleteByName(deleteByName);
                            break;
                        case 2:
                            System.out.printf("%nPlease enter the phone number:%n");
                            scanner.nextLine();
                            String deleteByNumber = scanner.nextLine();
                            jdbcImplement.deleteByPhoneNumber(deleteByNumber);
                            break;
                    }
                    break;
                case 5:
                    System.out.println();
                    Map<String, String> map = new HashMap<>(jdbcImplement.getAll());
                    System.out.printf("%-25s%-20s%n", "full name", "phone number");
                    for (String phone : map.keySet())
                        System.out.printf("%-25s%-20s%n", map.get(phone), phone);
                    System.out.println();
                    break;
            }
            userChoice = entry();
        }
        System.out.printf("%nExiting the program.%n");
    }
}

