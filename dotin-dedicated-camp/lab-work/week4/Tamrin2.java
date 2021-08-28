package Week4;

import java.util.Scanner;

public class Tamrin2 {

//    String a = "anahita";
//    String b = "a";
//    String c = null;

    public boolean isStringShorterThanFive(String input) {
        try {
            return input.length() > 5;
        }
        catch (NullPointerException exception) {
            System.out.println("the string is null.");
            return false;
        }
    }
    public static void main(String[] args) {
        Tamrin2 t = new Tamrin2();
        System.out.println(t.isStringShorterThanFive("anahita"));
        System.out.println(t.isStringShorterThanFive("h"));
        t.isStringShorterThanFive(null);
    }

}
