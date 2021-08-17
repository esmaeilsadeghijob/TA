package com.company.multexception;

import java.util.Scanner;

public class MultiException {

    int[] array;
    Scanner scanner;

    public MultiException() {

        this.array = new int[5];
        scanner = new Scanner(System.in);


    }

    public void display() {

        int arraySize = scanner.nextInt();

        try {

            for (int i = 0; i < arraySize; i++) {

                int value = scanner.nextInt();

                array[i] = value;

            }

            int divide = 0;

            for (int i = 0; i < array.length; i++) {

                System.out.print(array[i] + " ");

            }

            int result = array[0] / divide;

            System.out.print(result);

        } catch (ArithmeticException e) {

            System.err.println(e);

        } catch (IndexOutOfBoundsException e) {

            System.err.println(e);

        }

    }

}
