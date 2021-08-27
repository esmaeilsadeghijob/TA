import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class MyBufferedWriter {

        private static final String FILENAME = "/Users/neloufar/Desktop/filename.txt";
        public static void main(String[] args) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
                String content = "This is the content to write into file\n";
                bw.write(content);

                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }







