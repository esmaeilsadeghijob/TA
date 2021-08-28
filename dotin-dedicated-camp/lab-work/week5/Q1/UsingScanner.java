package TA04mapsa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {
        FileReader fileReader = null;
        Scanner scanner = null;
        try {
            fileReader = new FileReader("c:\\users\\mobin\\desktop\\word.txt");
            scanner = new Scanner(fileReader);
            System.out.printf("%-15s%-15s%-15s%-15s%n", "Account", "First Name", "Last Name", "Balance");
            while (scanner.hasNext()) {
                System.out.printf("%-15s%-15s%-15s%-15s%n", scanner.nextInt(), scanner.next(),
                        scanner.next(), scanner.nextDouble());
            }
        }catch(FileNotFoundException e){
            System.err.println("Error opening the file. Terminating.");
        }finally {
            if (scanner != null)
                scanner.close();
        }
    }
}
