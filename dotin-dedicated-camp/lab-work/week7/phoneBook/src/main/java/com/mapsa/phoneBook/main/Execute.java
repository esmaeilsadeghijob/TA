package com.mapsa.phoneBook.main;

import com.mapsa.phoneBook.database.FatemehJdbcCrud;
import com.mapsa.phoneBook.model.Phone;
import com.mapsa.phoneBook.model.PhoneType;
import com.mapsa.phoneBook.model.Subscriber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Execute {
    public static final String ANSI_CYAN = "\033[36;1m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_MAGENTA = "\033[35;1m";
    public static final String ANSI_YELLOW = "\033[33;1m";

    public void executeApplication() throws Exception {

        FatemehJdbcCrud fatemehJdbcCrud = new FatemehJdbcCrud();
        Scanner scanner = new Scanner(System.in);
        Boolean hasNextOrder = true;

        while (hasNextOrder) {

            String result;
            String name;
            String family;
            String phoneNumber;
            String oldPhoneNumber;
            String newPhoneNumber;
            String phoneTypeId;
            String addAgain;
            Subscriber subscriber;

            System.out.println(ANSI_MAGENTA + "--------------------------------------------");
            System.out.println(ANSI_MAGENTA + "---------------Manage Project---------------");
            System.out.println(ANSI_BLUE + "[1]: Add Phone Number");
            System.out.println(ANSI_BLUE + "[2]: Change Subscriber Info");
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
                    List<Phone> phoneList = new ArrayList<>();

                    System.out.println(ANSI_MAGENTA + "---------------Phone Type List---------------");
                    System.out.println(ANSI_BLUE + "[M]: Mobile");
                    System.out.println(ANSI_BLUE + "[H]: Home");
                    System.out.println(ANSI_BLUE + "[W]: Work");
                    System.out.println(ANSI_BLUE + "[S]: School");
                    System.out.println(ANSI_BLUE + "[F]: Fax");
                    System.out.println(ANSI_BLUE + "[O]: Other");
                    System.out.println(ANSI_MAGENTA + "--------------------------------------------");

                    do {
                        Phone phone = new Phone();
                        System.out.println(ANSI_CYAN + "Choose phone type from list: ");
                        phoneTypeId = scanner.nextLine().toUpperCase();

                        switch (phoneTypeId) {
                            case "M":
                                phone.setPhoneType(PhoneType.MOBILE);
                                break;
                            case "H":
                                phone.setPhoneType(PhoneType.HOME);
                                break;
                            case "W":
                                phone.setPhoneType(PhoneType.WORK);
                                break;
                            case "S":
                                phone.setPhoneType(PhoneType.SCHOOL);
                                break;
                            case "F":
                                phone.setPhoneType(PhoneType.FAX);
                                break;
                            default:
                                phone.setPhoneType(PhoneType.OTHER);
                        }

                        System.out.println(ANSI_CYAN + "Please enter phone number: ");
                        phoneNumber = scanner.nextLine();

                        phone.setNumber(phoneNumber);

                        phoneList.add(phone);

                        System.out.println(ANSI_BLUE + "Do you want to add another number? y/n ");
                        addAgain = scanner.nextLine().toUpperCase();

                    } while (addAgain.equals("Y"));

                    subscriber.setPhone(phoneList);
                    result = fatemehJdbcCrud.save(subscriber);

                    if (!result.equals("")) {
                        System.out.println(ANSI_RED + result + " already exist");
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

                    subscriber = new Subscriber().setName(name).setFamily(family).setPhone(Arrays.asList(new Phone().setNumber(phoneNumber)));
                    fatemehJdbcCrud.updateSubscriberInfo(subscriber);
                    fatemehJdbcCrud.close();
                    break;

                case "3":

                    System.out.println(ANSI_CYAN + "Please enter current phone number: ");
                    oldPhoneNumber = scanner.nextLine();

                    do {

                        System.out.println(ANSI_CYAN + "Please enter new phone number: ");
                        newPhoneNumber = scanner.nextLine();

                        subscriber = new Subscriber().setPhone(Arrays.asList(new Phone().setNumber(newPhoneNumber)));
                        result = fatemehJdbcCrud.updateSubscriberPhone(subscriber, oldPhoneNumber);

                        if (!result.equals("")) {
                            System.out.println(ANSI_RED + result +" already exist");
                        }
                    }while (!result.equals(""));

                    fatemehJdbcCrud.close();
                    break;

                case "4":

                    System.out.println(ANSI_CYAN + "Please enter phone number: ");
                    phoneNumber = scanner.nextLine();

                    subscriber = new Subscriber().setPhone(Arrays.asList(new Phone().setNumber(phoneNumber)));
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

                    subscriber = fatemehJdbcCrud.findByPhone(new Subscriber().setPhone(Arrays.asList(new Phone().setNumber(phoneNumber))));
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
