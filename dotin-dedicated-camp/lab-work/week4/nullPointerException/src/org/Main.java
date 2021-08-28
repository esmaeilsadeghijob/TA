package org;

import java.util.Scanner;

public class Main {
    public static boolean checkLength(String str)throws NullPointerException{
        if (str.length()==0){
            throw new NullPointerException("NullPointerException!");
        }
        if (str.length()>5){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        try {
            String s = input.nextLine();
            System.out.println(checkLength(s));
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            input.close();
        }
    }
}
