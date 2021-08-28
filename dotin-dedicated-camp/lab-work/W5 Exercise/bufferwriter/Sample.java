package com.amir.bufferwriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * this sample just write a file with buffer writer
 * @author : Amir hosseinnemat
 */
public class Sample {
    public static void main(String[] args) {
        // create list of songs
        ArrayList<String> songs = new ArrayList<>();
        Collections.addAll(songs, "hello by Adele","when we were young by Adele","attention by Charlie Puth");

        // create a file
        File file = new File("C:\\Users\\Amir\\Desktop\\week5\\src\\com\\amir\\bufferwriter\\songs.txt");

        // check the file exist for no
        if (!file.exists()){
            try {
                System.out.println("the songs file not exist in " + file.getCanonicalPath());
                file.createNewFile();

            } catch (IOException e) {
                System.out.println("can't find the file");
            }
        }

        // write song list in file with buffer writer
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(String.valueOf(songs));

            System.out.println("--------------------------------------");

            //close resources
            bw.close();
            if (file.exists())
                System.out.println("songs wrote successfully in " + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
