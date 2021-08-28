
import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            
            System.out.println("Reading...");
        }catch (Exception e ){
            System.out.println(e);
        }finally {
            
            input.close();
        }

        // Or we Can use This way !
        try(Scanner get = new Scanner(System.in)) {

        }catch (Exception e){
            System.out.println(e);
        }
    }
}