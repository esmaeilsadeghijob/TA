package homeworks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsingEnum {
    public static void main(String[] args) {
        System.out.printf("Choose an option:%n1)First option%n2)Second option%n3)Third Option%n");
        Scanner scanner = new Scanner(System.in);
        int i = -1;
        try{
            i = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("you must enter an integer.");
        }
        Enums[] options = Enums.values();
        switch (options[(i-1)]){
            case FIRST:
                System.out.println("you chose the first option.");
                break;
            case SECOND:
                System.out.println("you chose the second option.");
                break;
            case THIRD:
                System.out.println("you chose the third option.");
                break;

        }
    }
}
