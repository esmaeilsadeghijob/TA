package homeworks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsingTryCatch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your age:");
        try {
            int name = input.nextInt();
        }catch(InputMismatchException e){
            e.printStackTrace();
            System.out.println("The input format must be an integer.");
        }
    }
}
