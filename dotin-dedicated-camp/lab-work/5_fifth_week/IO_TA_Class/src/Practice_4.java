import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Practice_4 {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("src/Practice_4.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Hello World");
            bufferedWriter.close();
            System.out.println("Job Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
