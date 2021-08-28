package bmi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float height,weight;
        System.out.println("Enter your weight (K/g)");
        weight = scanner.nextFloat();

        System.out.println("Enter yor height (M)");
        height = scanner.nextFloat();

        Bmi user1 = new Bmi(height,weight);
        float bmi = user1.getBmi();
        System.out.println("Yor BMI is = "+bmi);

    }
}
