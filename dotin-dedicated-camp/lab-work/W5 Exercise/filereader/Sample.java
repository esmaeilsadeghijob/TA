package com.amir.filereader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * in this sample read a file with file reader
 */

public class Sample {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Amir\\Desktop\\week5\\src\\com\\amir\\filereader\\text.txt");

        try {
            FileReader fileReader = new FileReader(file);
            int line;
            while ((line = fileReader.read()) != -1) {
                System.out.print((char)line);
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
