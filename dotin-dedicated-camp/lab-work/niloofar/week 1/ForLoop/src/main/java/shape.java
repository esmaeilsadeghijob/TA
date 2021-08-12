
import java.util.Scanner;
public class shape {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows=scan.nextInt();
        System.out.println("Enter character as you wish: ");
        char ch=scan.next().charAt(0);
        System.out.print("\n");
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=rows-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=rows; j++){
                if(i==1 || i==rows || j==1 || j==rows){
                    System.out.print(ch);
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }





    }
}