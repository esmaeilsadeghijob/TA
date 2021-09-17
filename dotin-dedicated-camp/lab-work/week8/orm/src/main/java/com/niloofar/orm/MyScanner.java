package com.niloofar.orm;

import com.niloofar.orm.JDBC.DaoImplementation;
import com.niloofar.orm.JDBC.JDBCSingleton;
import com.niloofar.orm.model.Person;
import com.niloofar.orm.model.Student;

import java.util.List;
import java.util.Scanner;

public class MyScanner {
    Person p=new Person();
    Scanner scanner = new Scanner(System.in);
    JDBCSingleton jdbc = JDBCSingleton.getInstance();
    DaoImplementation generator = new DaoImplementation();
    static  int choice;
    public MyScanner() {

    do{
        System.out.println(" ---------------------------------- ");
        System.out.println(" 1. Create Table");
        System.out.println(" 2. Add New Record ");
        System.out.println(" 3. find All ");
        System.out.println(" 4. Update by id   ");
        System.out.println(" 5. Delete by id   ");
        System.out.println(" 6. Exit      ");
        System.out.println(" ----------------------------------\n ");
        System.out.print("Please enter the number choice what you want to(only the selected number)\n");
        choice=Integer.parseInt(scanner.next());
        switch(choice) {
            case 1:{
                try {
                    generator.creat(new Person());
                } catch (Exception e) {
                    System.out.println("Input is incorrect" + e.getMessage());
                }
                System.out.println("Press Enter key to continue...\n");

            }//End of case 1
            break;
            case 2:{

                System.out.print("Enter in order :>>>>>Id(Numerically):>>>>>:");
                p.setId(scanner.nextInt());
                System.out.print("plz Enter :>>>>>Name:>>>>>:");
                p.setName(scanner.next());

                try {
                    generator.add(p);
                } catch (Exception e) {
                    System.out.println("Input is incorrect" + e.getMessage());
                }
                System.out.println("Press Enter key to continue... \n");
                  }//End of case 2
            break;


            case 3:{
                try {
                    List<Person> ls = generator.getAll(p);
                    for (Person all : ls) {
                        System.out.println(all);
                    }
                } catch (Exception e) {
              e.getMessage();
                }
                System.out.println("Press Enter key to continue...\n");
            }//End of case 3
            break;


            case 4:{
                System.out.print("Enter the Id, you want to update:  \n ");
              int id1 = scanner.nextInt();
                System.out.print("plz Enter:>>>>>your new id:>>>>>:");
                p.setId(scanner.nextInt());
                System.out.print("plz Enter:>>>>>your new FirstName:>>>>>:");
                p.setName(scanner.next());
                try {
                    generator.update(p, id1);
                } catch (Exception e) {
                    System.out.println("Input is incorrect" + e.getMessage());
                }
                System.out.println("Press Enter key to continue...\n");
            }// end of case 4
            break;



            case 5:{
                System.out.print("Enter the  id, you want to delete: \n");
                int userid = Integer.parseInt(scanner.next());
                try {
                   generator.delete(p,userid);
                } catch (Exception e) {
                    System.out.println("Input is incorrect" + e.getMessage());
                }
                System.out.println("Press Enter key to continue...\n");
            }// end
            break;

            default:
                return;
        }

    } while (choice!=5);


}
}
