package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int[] num=new int[4];
        Scanner s=new Scanner(System.in);
	try{
        for (int i = 0; i < 5; i++) {
            num[i]=s.nextInt();
        }
    }catch(IndexOutOfBoundsException e){
        System.err.println("err");
    }finally {
	    s.close();

    }
        System.out.println(num[0]);
    }
}
