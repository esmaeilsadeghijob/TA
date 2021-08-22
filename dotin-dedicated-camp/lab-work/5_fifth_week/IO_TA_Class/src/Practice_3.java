import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Practice_3 {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream
                ("/home/huayra/IdeaProjects/TA/dotin-dedicated-camp/lab-work/5_fifth_week/IO_TA_Class/src/Practice_1.txt")){

            int i ;
            while ( (i = fileInputStream.read()) != -1)
                System.out.println((char) i);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
