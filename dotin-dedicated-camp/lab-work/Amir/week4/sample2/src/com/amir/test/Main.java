package com.amir.test;

public class Main {
    public static void main(String[] args) {
        String s = "abcd";

        test(null);
        test(s);
    }

    static void test(String x){
        try {
            System.out.println("First character: " + x.charAt(0));
        }
        catch(NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
    }
}
