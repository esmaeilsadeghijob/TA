package TA04mapsa;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringClass {
    public static void main(String[] args) {
        String string = "Maryam Raeisi";
        System.out.printf("my string variable is:%n%s", string);

        //Testing getBytes method without parameter:
        byte[] bytes = string.getBytes();
        System.out.printf("%n%n\"%s\" in UTF8 standard charset:(using getBytes method without parameter)%n", string);
        for (byte b : bytes) {
            System.out.printf(b + " ");
        }

        //Testing getBytes method with parameter StandardCharsets.UTF_8:
        byte[] bytes2 = string.getBytes(StandardCharsets.UTF_8);
        System.out.printf("%n%n\"%s\" in UTF8 standard charset:(using getBytes method with" +
                " StandardCharsets.UTF_8 parameter)%n", string);
        for (byte b : bytes2) {
            System.out.printf(b + " ");
        }

        //Testing compareTo method:
        String string2 = "Maryam";
        int i = string.compareTo(string2);
        System.out.printf("%n%nThe result of comparing \"%s\" with \"%s\" using compareTo method:%n%d"
                , string, string2, i);

        //Testing toString method:
        System.out.printf("%n%ntoString method output:%n%s", string.toString());

        //Testing toLowerCase method:
        System.out.printf("%n%ntoLowerCase method output:%n%s", string.toLowerCase());

        //Testing toUpperCase method:
        System.out.printf("%n%ntoUpperCase method output:%n%s",string.toUpperCase());

        //Testing equalsIgnoreCase method:
        String string3 = "maryam raeisi";
        System.out.printf("%n%nThe result of checking equality of \"%s\" with \"%s\" using equalsIgnoreCase method is:%n%b",
                string, string3, string.equalsIgnoreCase(string3));

        //Testing equals method:
        System.out.printf("%n%nThe result of checking equality of \"%s\" with \"%s\" using equals method is:%n%b",
                string, string3, string.equals(string3));

        //Testing charAt method:
        System.out.printf("%n%nFinding the character at index 3 of \"%s\" using charAt method:%n%c",
                string, string.charAt(3));

        //Testing codePointAt
        int j = string.codePointAt(1);
        System.out.printf("%n%nGetting the UTF_8 code of the character at index 1 using codePointAt method:%n%d", j);

        //Testing codePointBefore:
        int k = string.codePointBefore(3);
        System.out.printf("%n%nGetting the UTF_8 code of the character before index 3 using codePointBefore method:%n%d", k);

        //Testing codePointCount:
        int n = string.codePointCount(1 , 5);
        System.out.printf("%n%nCounting the number of code points between index 1 to 5 (excluding 5) using codePointCount method:%n%d", n);

        //Testing compareToIgnoreCase:
        System.out.printf("%n%nThe result of comparing \"%s\" with \"%s\" using compareToIgnoreCase method is:%n%d",
                string, string3, string.compareToIgnoreCase(string3));

        //Testing concat method:
        System.out.printf("%n%nConcating \"%s\" with \"%s\" using concat method:%n%s", string, string2, string.concat(string2));

        //Testing contains method:
        System.out.printf("%n%nChecking if \"%s\" contains \"%s\" using contains method:%n%b", string, "c", string.contains("c"));

        //Testing contentEquals method:
        System.out.printf("%n%nChecking if \"%s\" equals \"%s\" using contentEquals method:%n%b", string, "Mar", string.contentEquals("Mar"));

        //Testing static method copyValueOf:
        char[] charset = {'m', 'a', 'r', 'y'};
        System.out.printf("%n%nGetting the string value of charset [m, a, r, y] using copyValueOf method:%n%s", String.copyValueOf(charset));

        //Testing endsWith method:
        System.out.printf("%n%nChecking if \"%s\" ends with \"%s\" using endsWith method:%n%b", string, "isi", string.endsWith("isi"));

        //Testing static method format:
        System.out.print(String.format("%n%nUsing format method to write this text."));

        //Testing trim method:
        System.out.printf("%n%nTrimming \"%s\" using trim method:%n%s","  hi maryam raeisi  " , "  hi maryam raeisi  ".trim());

        //Testing toCharArray method:
        char[] charArray = string.toCharArray();
        System.out.printf("%n%nGetting \"%s\" as an charArray using toCharArray method and printing elements:%n", string);
        System.out.printf("%s", Arrays.toString(charArray));



    }
}
