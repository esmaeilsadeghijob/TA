package org;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter number");
        int length = input.nextInt();

        Shape shape1 = new Shape();
        shape1.square(length);
        System.out.println(" ");

        Shape shape2 = new Shape();
        shape2.rectangle(length - 1, length + 1);
        System.out.println(" ");

        Shape shape3 = new Shape();
        shape3.triangle(length);
        System.out.println(" ");

        Shape shape4 = new Shape();
        shape4.lozenge(length);
        System.out.println(" ");
    }
}
