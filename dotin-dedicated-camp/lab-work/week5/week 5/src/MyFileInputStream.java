import java.io.*;

public class MyFileInputStream {


    public static void main(String args[]) {

        try {
            InputStream is = new FileInputStream("F:\\lab-work\\TA\\dotin-dedicated-camp\\lab-work\\week5\\week 5\\n1.txt");
            int size = is.available();

            for(int i = 0; i < size; i++) {
                System.out.print((char)is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
}

