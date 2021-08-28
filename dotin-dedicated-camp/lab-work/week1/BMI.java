import java.util.Scanner;

public class BMI {

    public double bmi(double height, double weight) {
        double bmi = weight / (height * height);
        return bmi;
    }

    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);
        System.out.println("please enter your height in meter");
        double height = s1.nextDouble();
        Scanner s2 = new Scanner(System.in);
        System.out.println("please enter your weight in kilogram");
        double weight = s2.nextDouble();

        BMI o = new BMI();
        System.out.println("your body mass index is: " + o.bmi(height,weight));
    }
}
