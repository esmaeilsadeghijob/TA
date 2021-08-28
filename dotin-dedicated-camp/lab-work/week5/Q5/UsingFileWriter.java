package TA04mapsa;

import java.io.FileWriter;
import java.io.IOException;

public class UsingFileWriter {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("c:\\users\\mobin\\desktop\\UsingFileWriter.txt");
            fileWriter.write("Hi. ");
            fileWriter.write("This file is written using fileWriter.");
        }catch (IOException e){
            System.err.println("Error opening and writing to file. Terminating.");
        }finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            }catch (IOException e){
                System.err.println("Error closing the file. Terminating.");
            }
        }
    }
}
