package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int[] a=new int[5];
        Scanner s=new Scanner(System.in);
        try{
            for (int i = 0; i <6 ; i++) {
                System.out.println("pls enter a num");
                a[i] = s.nextInt();
            }
        }catch (Exception e){
            System.err.println("error is="+e);
        }


    }
}
