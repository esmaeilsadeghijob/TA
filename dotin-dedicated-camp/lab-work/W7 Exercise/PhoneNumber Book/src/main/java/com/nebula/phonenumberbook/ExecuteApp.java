package com.nebula.phonenumberbook;

import java.sql.SQLException;
import java.util.Scanner;

public class ExecuteApp {

    public void ExecuteApplication() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Statements statements = new Statements();

        // ask to enter an option
        System.out.println("1: add member\n2: delete member\n" +
                "3: update member\n4: show a member\n5: EXIT");

        // read an integer from user to choose the continues of application
        int userOptions = scanner.nextInt();

        if (userOptions <= 5 && userOptions >= 1) {

            while (userOptions != 5) {

                switch (userOptions) {

                    case 1:
                        statements.addRecord();
                        break;
                    case 2:
                        statements.deleteRecord();
                        break;
                    case 3:
                        statements.updateRecord();
                        break;
                    case 4:
                        statements.showRecord();
                        break;
                    default:
                        System.exit(0); // close program

                }

                // ask to enter an option
                System.out.println("1: add member\n2: delete member\n" +
                        "3: update member\n4: show a member\n5: EXIT");
                userOptions = scanner.nextInt();

            }

        } else {

            throw new IllegalArgumentException("Wrong number\n------------------\nPlease insert a value among 1 - 5:");

        }

    }

}
