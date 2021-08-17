package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print("* ");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print("* ");
            for (int j = 0; j <16 ; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < 10; i++) {
            System.out.print("* ");
        }
    }
}
