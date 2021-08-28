package TA04mapsa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UsingFileReader {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try{
            fileReader = new FileReader("c:\\users\\mobin\\desktop\\UsingFileReader.txt");
            int i;
            while (-1 != (i = fileReader.read())){
                System.out.printf("%c", (char) i);
            }
        }catch (FileNotFoundException e) {
            System.err.println("Error opening the file. Terminating.");
        }catch(IOException e){
            System.err.println("Error writing to file. Terminating.");
        }finally {
            try{
                if(fileReader != null)
                    fileReader.close();
            }catch (IOException e){
                System.err.println("Error closing the file. Terminating.");
            }
        }
    }
}
