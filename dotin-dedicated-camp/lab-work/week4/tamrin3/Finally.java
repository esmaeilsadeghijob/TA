package ta_workspace.tamrin3;

import java.util.Scanner;

public class Finally {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            // TODO: 8/17/2021  something use resource !
            System.out.println("Reading From HDD in progress");
        }catch (Exception e ){
            System.out.println(e);
        }finally {
            // TODO: 8/17/2021 Close reSource ;
            input.close();
        }

        // Or we Can use This way !
        try(Scanner get = new Scanner(System.in)) {

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
