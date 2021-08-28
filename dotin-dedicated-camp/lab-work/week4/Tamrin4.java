package Week4;

import java.util.Scanner;

public class Tamrin4 {
    String myCode = "1234";

    void unlock(String code) {
        try {
             if (code.equalsIgnoreCase(myCode)) {
                 System.out.println("code is correct, unlocked.");
             }
        } catch (NullPointerException e) {
            if (!code.equalsIgnoreCase(myCode)) {
                System.out.println("code is not correct");
            }
        }
        finally {
            System.out.println("anyway, we unlocked it for you.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the code.");
        String code = scanner.next();
        Tamrin4 t = new Tamrin4();
        t.unlock(code);
        t.unlock(null);
    }
}
