import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Practice_6 {
    public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader("/home/huayra/IdeaProjects/TA/dotin-dedicated-camp/lab-work/5_fifth_week/IO_TA_Class/src/Practice_1.txt");
            int file ;
            while ((file = fileReader.read()) != -1){
                System.out.println((char) file);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
