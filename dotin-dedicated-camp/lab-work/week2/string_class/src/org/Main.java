package org;

public class Main {
    public static void main(String[] args) {
        String str = "Hello my name is Fatemeh ,Fatemeh";
        System.out.println(str.isEmpty());
        System.out.println(str.length());
        System.out.println(str.charAt(2));
        System.out.println(str.startsWith("Hello"));
        System.out.println(str.contains("Fatemeh"));
        System.out.println(str.equals("Hello my name is fatemeh ,fatemeh"));
        System.out.println(str.equalsIgnoreCase("Hello my name is fatemeh ,fatemeh"));
        System.out.println(str.concat(" test"));
        System.out.println(str.indexOf("Fatemeh"));
        System.out.println(str.lastIndexOf("Fatemeh"));
        System.out.println(str.replaceAll("Fatemeh","Zahra"));
        System.out.println(str.substring(2,6));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());

        char[] c = str.toCharArray();
        for (char c1 : c) {
            System.out.println(c1);
        }

        String[] w = str.split(" ");
        for (String s : w) {
            System.out.println(s);
        }

    }
}
