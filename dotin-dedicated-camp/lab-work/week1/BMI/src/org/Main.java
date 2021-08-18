package org;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){

	Scanner input=new Scanner(System.in);
	System.out.println("enter your weight in kg");
	Bmi bmi=new Bmi();
	bmi.setWeight(input.nextFloat());
	System.out.println("enter your height in m");
	bmi.setHeight(input.nextFloat());
	System.out.println("your bmi = "+bmi.calculateBmi());

    }
}
