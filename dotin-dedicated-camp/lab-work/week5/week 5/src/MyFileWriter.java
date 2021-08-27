import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {

        public static void main(String[] args) throws IOException {
            FileWriter fw = new FileWriter("OUtputFile.txt", true);
            String text = "FileWriter example";
            char c = 'F';

            fw.write(text);
            fw.write("\n");
            fw.write(c);

            fw.close();
        }
    }

