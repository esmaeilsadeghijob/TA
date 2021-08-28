package com.mahdi.exercise;

import java.util.Scanner;

public class SquareTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please insert the value of the Square length: ");
        int length = scanner.nextInt();

        System.out.print("Please insert the value of the square width: ");
        int width = scanner.nextInt();

        Square square = new Square(length, width);
        square.displaySquare();
        square.displayObliqueSquare();

        System.exit(0);

    }

}
