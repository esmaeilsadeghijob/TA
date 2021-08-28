package ta.insurance;

import java.util.Scanner;

public class TehranInsurance extends Insurance {

    private Scanner input = new Scanner(System.in);
    private String objectInsurance;

    @Override
    public double insurancePriceForCar() {

        double totalPrice = 0.0;

        System.out.print("Do you have discount? (1 = yes, 2 = no): ");

        int answer = input.nextInt();

        if (answer == 1) {

            System.out.print("Please insert your dicount code: ");
            String discunt = input.nextLine();

            if (DataSaver.checkHaveDiscount(discunt) == true) {

                System.out.print("Please insert the number of capacity of your car: ");
                int numberOfPassenger = input.nextInt();
                totalPrice = (((numberOfPassenger * BasePrice.CAR_BASE_PRICE) * 25) / 100);

            } else {

                System.err.println("invalid discount code!");

            }

        } else {

            System.out.print("Please insert the number of capacity of your car: ");
            int numberOfPassenger = input.nextInt();
            totalPrice =(numberOfPassenger * BasePrice.CAR_BASE_PRICE);

        }

        return totalPrice;

    }

    @Override
    public double insurancePriceForHome() {

        double totalPrice = 0.0;

        System.out.print("Do you have discount? (1 = yes, 2 = no): ");

        int answer = input.nextInt();

        if (answer == 1) {

            System.out.print("Please insert your dicount code: ");
            String discunt = input.nextLine();

            if (DataSaver.checkHaveDiscount(discunt) == true) {

                System.out.print("Please insert the area of your home: ");
                int houseArea = input.nextInt();
                totalPrice = (((houseArea * BasePrice.HOME_BASE_PRICE) * 25) / 100);

            } else {

                System.err.println("invalid discount code!");

            }

        } else {

            System.out.print("Please insert the area of your home: ");
                int houseArea = input.nextInt();
                totalPrice = (houseArea * BasePrice.HOME_BASE_PRICE);

        }

        return totalPrice;

    }

    @Override
    public double insurancePriceForMotorcycle() {

         double totalPrice = 0.0;

        System.out.print("Do you have discount? (1 = yes, 2 = no): ");

        int answer = input.nextInt();

        if (answer == 1) {

            System.out.print("Please insert your dicount code: ");
            String discunt = input.nextLine();

            if (DataSaver.checkHaveDiscount(discunt) == true) {

                System.out.print("Please insert the value of weight of your Motorcycle: ");
                int numberOfPassenger = input.nextInt();
                totalPrice = (((numberOfPassenger * BasePrice.MOTORCYCLE) * 25) / 100);

            } else {

                System.err.println("invalid discount code!");

            }

        } else {

            System.out.print("Please insert the value of weight of your Motorcycle: ");
            int numberOfPassenger = input.nextInt();
            totalPrice =(numberOfPassenger * BasePrice.MOTORCYCLE);

        }

        return totalPrice;

    }

    @Override
    public void display() {

        System.out.println("Please Insert the type of your insurance: home, car, motorcycle: ");
        String answer = input.nextLine();
        
        if ("car".equals(answer)) {
            
            System.out.println(insurancePriceForCar());
            
        } else if (answer.equalsIgnoreCase("home")) {
            
            System.out.println(insurancePriceForHome());
            
        }else if (answer.equalsIgnoreCase("motorcycle")) {
        
            System.out.println(insurancePriceForMotorcycle());
            
        }

    }

}
