package homeworks;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Formatter;

public class ClosingTheSourceAfterTryCatch {
    public static void main(String[] args) {
        try(Formatter formatter = new Formatter("c:\\users\\mobin\\desktop\\test.txt")){;
            formatter.format("hello maryam.%nthis is a test.");
            formatter.flush();
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("The file was not found.");
        }
        System.out.println("The source is closed after try catch block.");
    }
}
