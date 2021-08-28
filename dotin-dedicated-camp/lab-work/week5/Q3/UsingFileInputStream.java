package TA04mapsa;

import java.io.FileInputStream;
import java.io.IOException;

public class UsingFileInputStream {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("c:\\users\\mobin\\desktop\\UsingFileInputStream.txt");
            int i;
            while (-1 != (i = fileInputStream.read())) {
                System.out.printf("%d ", (byte) i);
            }
        }catch (IOException e){
         System.err.println("Error opening and reading from file. Terminating.");
            }finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            }catch (IOException e){
                System.err.println("Error closing the file. Terminating.");
            }
        }
    }
}
