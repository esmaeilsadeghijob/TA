import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyIO {
    private static Scanner input;

    public static void main(String[] args) {
        openFile();
        readFile();
        closeFile();
    }
    public static void openFile(){
        try{
          input=new Scanner(Paths.get("F:\\lab-work\\TA\\dotin-dedicated-camp\\lab-work\\week5\\week 5\\n2.txt"));
        }catch (IOException e)
        {
            System.out.println("error open");
            System.exit(1);
        }
    }

    public static void readFile(){
        System.out.printf("%-10s%-12s%-12s%10s%n","account","First Name","Last Name","Balance");
        try {
            while (input.hasNext()){
              System.out.printf("%-10d%-12s%-12s%10.2f%n",input.nextInt(),input.next(),input.next(),input.nextDouble());
            }
        }catch (NoSuchElementException elementException){
            System.err.println("file format terminate");
        }
    }
    public static void closeFile(){
        if (input!=null)
            input.close();
    }
}
