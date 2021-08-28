import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\Mahdi\\Desktop\\bootcamp\\TA\\dotin-dedicated-camp\\lab-work\\week5\\io_exercise\\src\\test.txt");
        try {
            FileWriter fileWriter=new FileWriter(file);
            String text="Hello Fatemeh Batooei \nbye";
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("i write my text");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
