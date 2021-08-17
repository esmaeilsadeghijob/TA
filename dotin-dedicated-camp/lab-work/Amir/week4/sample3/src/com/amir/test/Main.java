package com.amir.test;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a number : ");

            try {
                int n = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Oops! Please enter a valid number!");
            }
            finally {
                scanner.close();
                System.out.println("scanner closed");
            }

            System.out.println("Goood Bye ...");
        }
    }

