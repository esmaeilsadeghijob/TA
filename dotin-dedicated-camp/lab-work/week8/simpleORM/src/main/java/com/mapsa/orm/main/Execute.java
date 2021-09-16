package com.mapsa.orm.main;

import com.mapsa.orm.database.CRUDGenerator;
import com.mapsa.orm.database.JdbcCrud;
import com.mapsa.orm.model.Person;
import java.sql.SQLException;
import java.util.Scanner;

public class Execute {
    public static final String ANSI_CYAN = "\033[36;1m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_MAGENTA = "\033[35;1m";
    public static final String ANSI_YELLOW = "\033[33;1m";

    public void executeApplication() throws Exception {

        JdbcCrud<Person> jdbcCrud = new CRUDGenerator<>();

        try {
            jdbcCrud.create(new Person());
            jdbcCrud.close();

        }catch (Exception e){
            if (e instanceof SQLException){
                System.out.println("Person table is already exist");
            }else{
                System.out.println(e.getMessage());
            }
        }

        Scanner scanner = new Scanner(System.in);
        Boolean hasNextOrder = true;

        while (hasNextOrder) {

            long id;
            String name;
            String family;
            Person person;
            Person newPerson;
            Person oldPerson;

            System.out.println(ANSI_MAGENTA + "----------The Person table is made---------");
            System.out.println(ANSI_MAGENTA + "-----------------Manage Person-------------");
            System.out.println(ANSI_BLUE + "[1]: Add Person");
            System.out.println(ANSI_BLUE + "[2]: Update Person by Id");
            System.out.println(ANSI_BLUE + "[3]: Delete Person by Id");
            System.out.println(ANSI_BLUE + "[4]: Find Person by Id");
            System.out.println(ANSI_BLUE + "[5]: Find All Person");
            System.out.println(ANSI_BLUE + "[6]: Exit");
            System.out.println(ANSI_MAGENTA + "--------------------------------------------");
            System.out.println(ANSI_MAGENTA + "--------------------------------------------");

            System.out.println(ANSI_MAGENTA + "Choose from menu and press Enter");

            switch (scanner.nextLine()) {
                case "1":

                    System.out.println(ANSI_CYAN + "Please enter first name: ");
                    name = scanner.nextLine();

                    System.out.println(ANSI_CYAN + "Please enter last name: ");
                    family = scanner.nextLine();

                    person = new Person().setName(name).setFamily(family);
                    jdbcCrud.save(person);
                    jdbcCrud.close();
                    person.toString();
                    break;

                case "2":

                    System.out.println(ANSI_CYAN + "Please enter person id: ");
                    id = scanner.nextLong();
                    oldPerson = jdbcCrud.selectById(Person.class, id);
                    scanner.nextLine();

                    System.out.println(ANSI_CYAN + "Please enter first name: ");
                    name = scanner.nextLine();

                    System.out.println(ANSI_CYAN + "Please enter last name: ");
                    family = scanner.nextLine();

                    newPerson = oldPerson.setName(name).setFamily(family);
                    jdbcCrud.update(newPerson);
                    jdbcCrud.close();
                    newPerson.toString();
                    break;

                case "3":

                    System.out.println(ANSI_CYAN + "Please enter person id: ");
                    id = scanner.nextLong();
                    scanner.nextLine();
                    jdbcCrud.delete(new Person().setId(id));
                    jdbcCrud.close();
                    break;

                case "4":

                    System.out.println(ANSI_CYAN + "Please enter person id: ");
                    id = scanner.nextLong();
                    scanner.nextLine();
                    person = jdbcCrud.selectById(Person.class, id);
                    jdbcCrud.close();
                    person.toString();
                    break;

                case "5":

                    for (Object persons : jdbcCrud.selectAll(Person.class)) {
                        persons.toString();
                    }
                    jdbcCrud.close();
                    break;

                case "6":

                    hasNextOrder = false;
                    break;

                default:
                    System.out.println(ANSI_MAGENTA + "Choose from menu and press Enter");
            }
        }
    }
}
