package com.company.finallytest;

import java.util.Scanner;

public class FinallyTest {

    Scanner scanner;

    public FinallyTest() {

        this.scanner = new Scanner(System.in);

    }

    public void display() {


        try {

            String inputString = scanner.nextLine();

            if (inputString == null) {

                throw new NullPointerException("Input string must be not null");

            }

            if (inputString.length() > 5) {

                System.out.printf("%s have more than 5 character", inputString);

            } else {

                System.out.printf("%s have less than 5 character", inputString);

            }


        } catch (NullPointerException e) {

            System.err.println("Input string must be not null");

        } finally {

            scanner.close();
            System.out.println("The method do all his deity");

        }


    }

}
