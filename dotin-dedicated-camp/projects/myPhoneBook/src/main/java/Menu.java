import java.beans.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    MyStatement myStatement;
    public int myMenu() throws SQLException {
        Scanner s = new Scanner(System.in);
        myStatement = new MyStatement();
        System.out.print("please choose one of the options: \n" +
                "-------------------------------- \n" +
                "1. creating new user. \n" +
                "2. updating user. \n" +
                "3. deleting a user. \n" +
                "4. search. \n" +
                "-------------------------------- \n" +
                "enter one of the numbers from 1 to 4: ");

        return s.nextInt();
    }

    public void select() throws SQLException {
        int select = myMenu();
        switch (select){
            case 1 :
                //creat
                myStatement.create();
                break;
            case 2 :
                //update
                myStatement.update();
                break;
            case 3 :
                //delete
                myStatement.delete();
                break;
            case 4 :
                //search
                myStatement.serach();
                break;
            default:
                System.out.println("you chose a wrong number, try again.");
        }
    }
}
