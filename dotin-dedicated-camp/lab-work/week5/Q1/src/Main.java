import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("test.txt"));

        while (file.hasNext()) {
            for (int i = 0; i < 4; i++) {
                System.out.print(file.next() + "   ");
            }
            System.out.println();
        }
    }
}

