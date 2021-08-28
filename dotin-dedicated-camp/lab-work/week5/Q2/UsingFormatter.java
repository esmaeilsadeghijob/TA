package TA04mapsa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class UsingFormatter {
    public static void main(String[] args) {
        Formatter formatter = null;
        try{
            formatter = new Formatter("c:\\users\\mobin\\desktop\\UsingFormatter.txt");
            formatter.format("400 pooya pooya 400.00%n");
            formatter.format("200 pooya mah 40000.00%n");
        }catch(IOException e){
            System.err.println("Error opening and writing to file. Terminating.");
        }finally {
            if (formatter != null)
                formatter.close();
        }
    }
}
