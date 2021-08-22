import java.io.FileNotFoundException;
import java.util.Formatter;

public class Practice_2 {
    private Formatter outPut;




    public static void main(String[] args) throws FileNotFoundException {
        Practice_2 practice_2 = new Practice_2();
        String outPutName = "src/Practice_2.txt";
        practice_2.outPut = new Formatter(outPutName);
        String text = "400 pooya pooya 200.00\n" +
                        "200 pooya mah 4000.00\n";
        practice_2.outPut.format(text);
        practice_2.outPut.close();

    }
}
