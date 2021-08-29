package com.company;



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> songs = new ArrayList<>();
        Collections.addAll(songs, "hello my dear");


        File file = new File("C:\\Users\\Asus\\Desktop\\week5\\test1.txt");


        if (!file.exists()){
            try {
                System.out.println("the songs file not exist in " + file.getCanonicalPath());
                file.createNewFile();

            } catch (IOException e) {
                System.err.println("can't find the file");
            }
        }


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(String.valueOf(songs));


            bw.close();
            if (file.exists())
                System.out.println("songs wrote successfully in " + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
