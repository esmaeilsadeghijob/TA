package com.amir.test;

    enum BMI {
        UNDERWEIGHT,
        NORMAL,
        OVERWEIGHT
    }

    public class Main {
        public static void main(String[] args) {
            BMI myBmi = BMI.NORMAL;

            switch(myBmi) {
                case UNDERWEIGHT:
                    System.out.println("your bmi is less than 18");
                    break;
                case NORMAL:
                    System.out.println("your bmi is between 18 and 25");
                    break;
                case OVERWEIGHT:
                    System.out.println("your bmi is more than 25");
                    break;
            }
        }
    }

