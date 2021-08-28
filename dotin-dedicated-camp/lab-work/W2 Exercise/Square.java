package com.mahdi.exercise;

public class Square {

    int length;
    int width;

    public Square(int length, int width) {
        this.length = length;
        this.width = width;
    }

    private int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void displaySquare() {

        for (int row = length; row > 0; row--) {

            for (int column = 0; column < width; column++) {

                if (row == 1 || row == length || column == 0 || column == width - 1) {

                    System.out.print("*");

                }else{

                    System.out.print(" ");

                }

            }

            System.out.println();

        }

    }

    public void displayObliqueSquare() {

        for (int row = length; row > 0; row--) {

            System.out.print(" ".repeat(row - 1));

            for (int column = 0; column < width; column++) {

                if (row == 1 || row == length || column == 0 || column == width - 1) {

                    System.out.print("*");

                }else{

                    System.out.print(" ");

                }

            }

            System.out.println();

        }

    }

}
