import java.util.Scanner;

public class BmiMain {
    public static void main(String[] args) {
        // creating an object from Scanner
        Scanner sc = new Scanner(System.in);
        // creating an objec than the Calc Class
        Calc c1 = new Calc();

        // prompt the users to enter their Weights values
        // and storing its value in a variable --> w
        System.out.println("Enter Your Weight Pls: ");
        float w = sc.nextFloat();

        // prompt the users to enter their Heights values
        // and storing its value in a variable --> h
        System.out.println("Enter Your Height Pls: ");
        float h = sc.nextFloat();

        // calling the Calc object and passing the variables to it
        c1.bmiCalc(w, h);
    }
}
