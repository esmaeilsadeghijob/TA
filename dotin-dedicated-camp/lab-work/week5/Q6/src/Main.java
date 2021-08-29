import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader inf= new FileReader("test.txt");
        int chCode;
        while(-1 != (chCode=inf.read()) )
            System.out.print((char)chCode);
        inf.close();
    }
}
