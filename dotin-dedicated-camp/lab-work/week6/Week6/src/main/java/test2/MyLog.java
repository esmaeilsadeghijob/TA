package test2;

import java.util.Scanner;
import java.util.logging.Logger;

public class MyLog {
    private final static Logger LOGGER = Logger.getLogger(MyLog.class.getName());

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("please enter a and b for a/b ");
        int a = s.nextInt();
        int b = s.nextInt();
        if (b == 0){
            LOGGER.warning("you can not divide a number to zero.");
        }
        else {
            System.out.println(a/b);
            LOGGER.info("division has been completed.");
        }
    }
}
