package com.Insurance.dev;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InputMismatchException{

            Scanner scanner = new Scanner(System.in);
            scan s = new scan();
            System.out.println("please enter Insurance parameter for home");
            s.setHome(scanner.nextDouble());
            System.out.println("please enter Insurance parameter for motor");
            s.setMotor(scanner.nextDouble());
            System.out.println("please enter Insurance parameter for car");
            s.setCar(scanner.nextDouble());
            System.out.println("if you have discount please enter it");
            s.setDiscountCode(scanner.nextInt());
            Tehran tehran = new Tehran();
            Discount discount = new Discount();

try {
    if (discount.getArrayList().contains(s.getDiscountCode())) {
        System.out.println("price with discount will be");

        double finalCarPrice = tehran.InsurancePriceForCar(s.getCar());
        System.out.println("car ->" + (finalCarPrice - (finalCarPrice / 4)));

        double finalHomePrice = tehran.InsurancePriceForHome(s.getHome());
        System.out.println("home ->" + (finalHomePrice - (finalHomePrice / 4)));

        double finalMotorPrice = tehran.InsurancePriceForMotor(s.getMotor());
        System.out.println("motor ->" + (finalMotorPrice - (finalMotorPrice / 4)));

    } else {
        System.out.println("price without discount will be");
        System.out.println("car -> " + tehran.InsurancePriceForCar(s.getCar()));
        System.out.println(" home -> " + tehran.InsurancePriceForHome(s.getHome()));
        System.out.println(" motor -> " + tehran.InsurancePriceForMotor(s.getMotor()));

    }
}catch (RuntimeException e){
   e.printStackTrace();
}
     }
    }

