import java.io.FileWriter;
import java.io.IOException;

public class Practice_5 {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("src/Practice_5.txt");
            fileWriter.write("Hello World \nits Practice 5");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
