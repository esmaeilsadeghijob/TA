import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age:");
        int age = 0;
        boolean validAge = false;
        while(!validAge){
            try{
                String str = scanner.next();
                age = Integer.parseInt(str);
                validAge = true;
            }catch(Exception e){
                System.out.println("Enter a valid number:");
            }
            finally {
                scanner.close();
            }
        }
        System.out.println("You are " + age + " years old");
    }
}

