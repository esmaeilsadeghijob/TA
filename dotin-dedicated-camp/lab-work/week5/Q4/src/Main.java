import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter file = new BufferedWriter(new FileWriter("test.txt"));

        file.write("400 fatemeh jafari 400.00\n");
        file.write("400 fatemeh jafari 400.00\n");
        file.close();
    }
}