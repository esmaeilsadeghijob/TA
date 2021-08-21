package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int num=s.nextInt();

        int result;
        try {
             result=num/0;
        }catch (ArithmeticException a){
            System.err.println("devide by zero");
            result=1;
        }finally{
            System.out.println("error but continue...");;
        }
        System.out.println("pls enter 5 numbers:");
        int[] a=new int[5];

        for (int i = 0; i < 5; i++) {
            a[i] = s.nextInt();
            result*= a[i];
        }

        System.out.println("Multiply the given numbers="+result);
    }
}
