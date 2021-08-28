import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class IOException {
    public static void main(String[] args) throws java.io.IOException {
        File file = new File("C:\\Users\\ASUS\\Desktop");
        FileReader fileReader = new FileReader(file);
        fileReader.read();

    }
}
