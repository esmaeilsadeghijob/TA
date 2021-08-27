import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    public static void main(String[] args) throws IOException {

            FileReader fr=new FileReader("F:\\lab-work\\TA\\dotin-dedicated-camp\\lab-work\\week5\\week 5\\n1.txt");
             char ch = (char)fr.read();
              System.out.println("Single character read: " + ch);
             System.out.println("Single character read: " + (char)fr.read());

              fr.close();

    }

}




