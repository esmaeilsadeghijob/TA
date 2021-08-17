package ta_workspace.tamrin2;

import java.util.Scanner;

public class TryCatch {
    static boolean checkLenght(String text){
        if (text == null)
            throw new NullPointerException("Error Null parametr !");
        else if (text.length()>4)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            System.out.println(checkLenght(input.next()));
        }catch (NullPointerException e){
            System.out.println(e);
        }
    }
}
