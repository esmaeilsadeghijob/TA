
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyBufferedWriter {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Mahdi\\Desktop\\bootcamp\\TA\\dotin-dedicated-camp\\lab-work\\week5\\io_exercise\\src\\test1.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            String text="exercise";
            bufferedWriter.write(text);
            bufferedWriter.close();
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

