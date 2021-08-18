package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] name = new String[5];
        System.out.println("pls enter 4 names and a num");
        name[0]=null;
        try {
        for (int i = 1; i < 5; i++) {
            name[i] = s.next();
        }
        int num=s.nextInt();

            for (int i = 1; i < num; i++) {
                System.out.println(name[i]);
            }
            for (int i = 0; i < num; i++) {
                System.out.println(name[i].length());
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("invalid index of name");
        } catch (NullPointerException n) {
            System.out.println("invalid length of name");
        }catch (InputMismatchException i){
            System.out.println("not a num");
        }
    }
}