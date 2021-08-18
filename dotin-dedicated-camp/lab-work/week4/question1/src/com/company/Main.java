package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BirdsOuter.FlyInner b=new BirdsOuter().new FlyInner();
        Scanner s=new Scanner(System.in);
        System.out.println("pls enter count of birds ");
        int count=s.nextInt();
        b.birdsFly(count);
    }
}
