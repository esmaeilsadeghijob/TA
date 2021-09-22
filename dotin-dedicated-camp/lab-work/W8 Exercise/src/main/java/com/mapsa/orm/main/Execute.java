package com.mapsa.orm.main;

import com.mapsa.orm.database.CRUDGenerator;
import com.mapsa.orm.database.Crud;
import com.mapsa.orm.model.Car;
import com.mapsa.orm.model.Dags;
import com.mapsa.orm.model.Objects;
import com.mapsa.orm.model.Person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Execute {

    private Scanner scanner = new Scanner(System.in);

    public void executeApplication() throws SQLException, IOException {

        Crud crud = new CRUDGenerator();

        System.out.print("Please choose your option ==>> \n1: create table\n2: add record\n3: delete record\n" +
                "4: update record\n5: show a record\n6: show all record\n7: exit ");

        // read an integer from user to choose the continues of application
        int userOptions = scanner.nextInt();
        scanner.nextLine();// to solve next method problem

        if (userOptions <= 7 && userOptions >= 1) {

            while (userOptions != 7) {

                switch (userOptions) {

                    case 1:
                        crud.createTable(findObject());
                        break;
                    case 2:
                        crud.addRecord(findObject());
                        break;
                    case 3:
                        crud.deleteRecord(findObject());
                        break;
                    case 4:
                        crud.updateRecord(findObject());
                        break;
                    case 5:
                        crud.showRecord(findObject());
                        break;
                    case 6:
                        crud.showAllRecord(findObject());
                        break;
                    case 7:
                        System.exit(0); // close program


                }

                System.out.print("Please choose your option ==>> \n1: create table\n2: add record\n3: delete record\n" +
                        "4: update record\n5: show a record\n6: show all record\n7: exit ");

                // read an integer from user to choose the continues of application
                userOptions = scanner.nextInt();
                scanner.nextLine();

            }

        } else {

            throw new IllegalArgumentException("Wrong number\n------------------\nPlease insert a value among 1 - 7:");

        }

    }

    private Object findObject() {

        Objects object = null;

        System.out.print("Please insert object name: ");
        String objectName = scanner.nextLine();

        System.out.print("Please insert the type of object person\n1: Without Initialize\n2:full initialize ");
        int chooseNumber = scanner.nextInt();

        switch (objectName) {


            case "Person":

                if (chooseNumber == 1) {

                    object = Person.builder().build();

                } else {

                    System.out.print("Please insert the value of person id's: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Please insert the value of person first name's: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Please insert the value of person last name's: ");
                    String lastName = scanner.nextLine();

                    object = Person.builder().id(id).firstName(firstName).lastName(lastName).build();

                }
                break;

            case "Car":

                if (chooseNumber == 1) {

                    object = Car.builder().build();

                } else {

                    System.out.print("Please insert the value of car id's: ");
                    int carId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Please insert the value of person car company name's: ");
                    String carCompanyName = scanner.nextLine();

                    System.out.print("Please insert the value of person car model name's: ");
                    String carModelName = scanner.nextLine();

                    object = Car.builder().carId(carId).carCompanyName(carCompanyName).carModelName(carModelName).build();

                }
                break;


            case "Dags":

                if (chooseNumber == 1) {

                    object = Dags.builder().build();

                } else {


                    System.out.print("Please insert the value of dag number's: ");
                    int dagNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Please insert the value of person dag bread name's: ");
                    String dagBreed = scanner.nextLine();

                    System.out.print("Please insert the value of person dag name's: ");
                    String dagName = scanner.nextLine();

                    object = Dags.builder().dagNumber(dagNumber).dogBreed(dagBreed).dagName(dagName).build();
                }
                break;


            default:
                System.out.println("Please check your input: Car, Person, Dags");

        }

        return object;

    }


}
