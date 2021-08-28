import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Mahdi\\Desktop\\bootcamp\\TA\\dotin-dedicated-camp\\lab-work\\week5\\io_exercise\\src\\test.txt");
        try {
            FileReader fileReader = new FileReader(file);
            int data = fileReader.read();
            String content="";
            while (data != -1) {
                System.out.println((char) data);
                content+=(char)data;
                data = fileReader.read();
            }
            System.out.println(content);
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
