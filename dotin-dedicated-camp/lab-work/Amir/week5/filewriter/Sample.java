package com.amir.filewriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * this sample just write a file with file writer
 * @author : Amir hosseinnemat
 */


public class Sample {

    public static void main(String[] args) {

        String text = "Hello, World";
        File file = new File("C:\\Users\\Amir\\Desktop\\week5\\src\\com\\amir\\filewriter\\text.txt");
        try {

            if (file.exists()) {
                System.out.println("file exist in " + file.getCanonicalPath());
            } else {
                file.createNewFile();
                System.out.println("file created in " + file.getCanonicalPath());
            }

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            System.out.println("text wrote in file successfully");
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
