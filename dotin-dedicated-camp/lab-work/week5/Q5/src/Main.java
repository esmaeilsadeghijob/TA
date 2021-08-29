import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("test.txt", true);

        file.write("400 fatemeh jafari 400.00\n");
        file.write("200 fatemeh jafari 40000.00\n");
        file.close();
    }
}
