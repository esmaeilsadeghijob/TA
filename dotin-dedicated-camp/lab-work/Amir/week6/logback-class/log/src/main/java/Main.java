import java.util.Date;
import java.util.Scanner;

import java.util.logging.Logger;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        // check number even or not
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer : ");
        int number = input.nextInt();

        if (number %2 == 0){
            LOGGER.info("input value is even " + new Date());
            System.out.println("Correct");
        } else {
            LOGGER.warning("incorrect input value");
            System.out.println("false");
        }

    }
}
