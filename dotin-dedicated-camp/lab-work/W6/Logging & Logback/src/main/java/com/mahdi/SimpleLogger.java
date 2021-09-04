package com.mahdi;

import java.util.Scanner;
import java.util.logging.Logger;

public class SimpleLogger {

    private final Logger LOGGER = Logger.getLogger(SimpleLogger.class.getName());

    public void logging() {


        // check number equal 10 or not
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer : ");
        int number = input.nextInt();

        if (number == 10){
            System.out.println("Correct");
        } else {
            LOGGER.warning("incorrect input value");
            System.out.println("false");
        }

    }
}
