package com.company;

import java.util.Scanner;

public class Main {
    enum result{
        win,
        lose,
        equal
    }

    public static void main(String[] args) {
        int[] tas=new int[6];
        int[] num=new int[3];
        int res=0;
        for (int i = 0; i < 6; i++) {
            tas[i]=i*4;
        }
        Scanner s=new Scanner(System.in);
        System.out.println("pls enter 3 num between 0 and 5");
        for (int i = 0; i <3 ; i++) {
            try{
                num[i]=s.nextInt();
                res+=tas[num[i]];

            }catch (Exception e) {
                System.out.println("invalid num");
            }

        }
        if (res%10==0) System.out.println(result.lose);
        else if (res%3==0) System.out.println(result.win);
        else System.out.println(result.equal);
    }
}
