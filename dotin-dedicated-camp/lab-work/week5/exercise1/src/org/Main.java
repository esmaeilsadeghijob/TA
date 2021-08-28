package org;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static Scanner input;

    public static void main(String[] args) {
        openFile();
        readFile();
        closeFile();
    }

    public static void openFile() {
        try {
            input = new Scanner(Paths.get("C:\\Users\\Mahdi\\Desktop\\bootcamp\\TA\\dotin-dedicated-camp\\lab-work\\week5\\exercise1\\src\\org\\text.txt"));
        } catch (IOException e) {
            System.out.println("error open file");
            e.printStackTrace();
        }
    }

    public static void readFile() {
        System.out.printf("%-10s%-12s%-12s%10s%n","account", "First Name", "Last Name", "Balance");
        while (input.hasNext()) {
            System.out.printf("%-10d%-12s%-12s%10.2f%n",input.nextInt(), input.next(), input.next(), input.nextFloat());
        }
    }

    public static void closeFile() {
        input.close();
    }

}
