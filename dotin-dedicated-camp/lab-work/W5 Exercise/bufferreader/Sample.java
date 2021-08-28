package com.amir.bufferreader;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * in this sample read a file with buffer reader
 * @author Amir hosseinnemat
 */
public class Sample {

    public static void main(String[] args) {
        // create an array list
        ArrayList<String> songs = new ArrayList<>();

        //create a file object and get the song.txt path
        File file = new File("C:\\Users\\Amir\\Desktop\\week5\\src\\com\\amir\\bufferreader\\songs.txt");

        // read file using buffer reader
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                songs.add(line);
            }br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(songs);
        // sort the list
        Collections.sort(songs);
        System.out.println(songs);
    }

}
