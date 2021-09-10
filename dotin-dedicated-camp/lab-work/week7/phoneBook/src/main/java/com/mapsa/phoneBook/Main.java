package com.mapsa.phoneBook;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static final String ANSI_CYAN = "\033[36;1m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_MAGENTA = "\033[35;1m";
    public static final String ANSI_YELLOW = "\033[33;1m";

    public static void main(String[] args) throws SQLException {

        FatemehJdbcCrud fatemehJdbcCrud = new FatemehJdbcCrud();
        Scanner scanner = new Scanner(System.in);
        Boolean hasNextOrder = true;

        while (hasNextOrder) {

            boolean result;
            String name;
            String family;
            String phoneNumber;
            String oldPhoneNumber;
            String newPhoneNumber;
            Subscriber subscriber;

            System.out.println(ANSI_MAGENTA + "--------------------------------------------");
            System.out.println(ANSI_MAGENTA + "---------------Manage Project---------------");
            System.out.println(ANSI_BLUE + "[1]: Add Phone Number");
            System.out.println(ANSI_BLUE + "[2]: Change Subscriber Name Or Family");
            System.out.println(ANSI_BLUE + "[3]: Change Subscriber Phone Number");
            System.out.println(ANSI_BLUE + "[4]: Remove Phone Number ");
            System.out.println(ANSI_BLUE + "[5]: Phone Number List ");
            System.out.println(ANSI_BLUE + "[6]: Show Subscriber Info By Phone Number ");
            System.out.println(ANSI_BLUE + "[7]: Show Subscriber Info By Name And Family");
            System.out.println(ANSI_BLUE + "[8]: Exit");
            System.out.println(ANSI_MAGENTA + "--------------------------------------------");
            System.out.println(ANSI_MAGENTA + "--------------------------------------------");

            System.out.println(ANSI_MAGENTA + "Choose from menu and press Enter");

            switch (scanner.nextLine()) {

                case "1":

                    System.out.println(ANSI_CYAN + "Please enter first name: ");
                    name = scanner.nextLine();

                    System.out.println(ANSI_CYAN + "Please enter last name: ");
                    family = scanner.nextLine();

                    subscriber = new Subscriber().setName(name).setFamily(family);

                    result = false;

                    while (!result) {

                        System.out.println(ANSI_CYAN + "Please enter phone number: ");
                        phoneNumber = scanner.nextLine();

                        subscriber.setPhone(phoneNumber);
                        result = fatemehJdbcCrud.save(subscriber);

                        if (!result){
                            System.out.println(ANSI_RED + "phone number already exist");
                        }
                    }

                    fatemehJdbcCrud.close();
                    break;

                case "2":

                    System.out.println(ANSI_CYAN + "Please enter phone number: ");
                    phoneNumber = scanner.nextLine();

                    System.out.println(ANSI_CYAN + "Please enter first name: ");
                    name = scanner.nextLine();

                    System.out.println(ANSI_CYAN + "Please enter last name: ");
                    family = scanner.nextLine();

                    subscriber = new Subscriber().setName(name).setFamily(family).setPhone(phoneNumber);
                    fatemehJdbcCrud.updateSubscriberInfo(subscriber);
                    fatemehJdbcCrud.close();
                    break;

                case "3":

                    System.out.println(ANSI_CYAN + "Please enter current phone number: ");
                    oldPhoneNumber = scanner.nextLine();

                    result = false;

                    while (!result) {

                        System.out.println(ANSI_CYAN + "Please enter new phone number: ");
                        newPhoneNumber = scanner.nextLine();

                        subscriber = new Subscriber().setPhone(newPhoneNumber);
                        result = fatemehJdbcCrud.updateSubscriberPhone(subscriber, oldPhoneNumber);

                        if (!result){
                            System.out.println(ANSI_RED + "phone number already exist");
                        }
                    }

                    fatemehJdbcCrud.close();
                    break;

                case "4":

                    System.out.println(ANSI_CYAN + "Please enter phone number: ");
                    phoneNumber = scanner.nextLine();

                    subscriber = new Subscriber().setPhone(phoneNumber);
                    fatemehJdbcCrud.delete(subscriber);
                    fatemehJdbcCrud.close();
                    break;

                case "5":

                    for (Subscriber persons : fatemehJdbcCrud.findAll()) {
                        System.out.println(persons.toString());
                    }
                    fatemehJdbcCrud.close();
                    break;

                case "6":

                    System.out.println(ANSI_CYAN + "Please enter phone number: ");
                    phoneNumber = scanner.nextLine();

                    subscriber = fatemehJdbcCrud.findByPhone(new Subscriber().setPhone(phoneNumber));
                    System.out.println(subscriber.toString());
                    fatemehJdbcCrud.close();
                    break;

                case "7":
                    System.out.println(ANSI_CYAN + "Please enter subscriber first name:");
                    name = scanner.nextLine();

                    System.out.println(ANSI_CYAN + "Please enter subscriber last name:");
                    family = scanner.nextLine();

                    for (Subscriber oneSubscriber : fatemehJdbcCrud.findByNameAndFamily(new Subscriber().setName(name).setFamily(family))) {
                        System.out.println(oneSubscriber.toString());
                    }

                    fatemehJdbcCrud.close();
                    break;

                case "8":

                    hasNextOrder = false;
                    break;

                default:
                    System.out.println(ANSI_MAGENTA + "Choose from menu and press Enter");
            }
        }
    }
}

