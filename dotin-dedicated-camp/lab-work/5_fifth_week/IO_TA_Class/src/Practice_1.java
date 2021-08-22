import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Practice_1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/huayra/IdeaProjects/TA/dotin-dedicated-camp/lab-work/5_fifth_week/IO_TA_Class/src/Practice_1.txt");
        Scanner scanner  = new Scanner(file);
        String splitWord ;
        System.out.println("Account       First Name      Last Name       Blance");
        while (scanner.hasNextLine()){
            String[] line = scanner.nextLine().split(" ");
            for (int i = 0; i < line.length ; i++) {
                System.out.print(line[i] + "           ");
            }
            System.out.println("\n");
        }
    }
}
