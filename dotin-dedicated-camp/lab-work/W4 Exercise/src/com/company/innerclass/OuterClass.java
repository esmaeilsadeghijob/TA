package com.company.innerclass;

public class OuterClass {

    private int data;

    private void displayData() {

        System.out.println(data);

    }

    public class innerclass{

        public void display() {

            data++;
            displayData();

        }

    }

}
