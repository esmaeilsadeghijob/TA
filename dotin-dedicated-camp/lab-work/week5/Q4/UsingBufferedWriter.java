package TA04mapsa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UsingBufferedWriter {
    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("c:\\users\\mobin\\desktop\\UsingBufferedWriter.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Hi.");
            bufferedWriter.newLine();
            bufferedWriter.write("This file is written using bufferedWriter.");
        }catch (IOException e){
            System.err.println("Error opening and writing to file. Terminating.");
        }finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            }catch(IOException e){
                System.err.println("Error closing the file. Terminating.");
            }
        }
    }
}
