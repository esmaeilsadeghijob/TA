import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyFileInputStream {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Mahdi\\Desktop\\bootcamp\\TA\\dotin-dedicated-camp\\lab-work\\week5\\io_exercise\\src\\test1.txt");
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            /*fileInputStream.read();*/
            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
            int data = 0;
            data = bufferedInputStream.read();
            String content="";
            while (data!=-1){
                System.out.println((char) data);
                content+=(char)data;
                data = bufferedInputStream.read();
            }
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
