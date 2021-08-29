package com.company;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Asus\\Desktop\\week5\\test2.txt");

        try {
            FileReader fileReader = new FileReader(file);
            int num;
            while ((num = fileReader.read()) != -1) {
                System.out.print((char)num);
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}