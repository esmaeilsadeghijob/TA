package com.company;



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String[] args) {

        ArrayList<String> songs = new ArrayList<>();


        File file = new File("C:\\Users\\Asus\\Desktop\\week5\\test.txt");


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String num;
            while ((num = br.readLine()) != null) {
                songs.add(num);
            }br.close();
        } catch (IOException e) {
            System.err.println("error");
        }

        System.out.println(songs);

        Collections.sort(songs);
        System.out.println(songs);
    }

}
