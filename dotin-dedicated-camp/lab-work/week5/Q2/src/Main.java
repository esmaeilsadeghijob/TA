import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) throws IOException {
        Formatter file = new Formatter(new FileWriter("test.txt"));

        file.format("400 fatemeh jafari 400.00" + "\n" + "200 fatemeh jafari 40000.00");
        file.flush();
    }
}

