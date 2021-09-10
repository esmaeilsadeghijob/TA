import java.util.ArrayList;
import java.util.Scanner;

public class MyScanner {
static  int choice;
public MyScanner() {
    NiloofarJDBC N=new NiloofarJDBC();
    Person p=new Person();
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> mylist = new ArrayList<>();


    do{
        System.out.println("=======PhoneBook===niLLooooofar========");
        System.out.println(" ---------------------------------- ");
        System.out.println(" 1. find all..Show all Contacts");
        System.out.println(" 2. Add New Contact ");
        System.out.println(" 3. find Contact by id ");
        System.out.println(" 4. Update Contact by id   ");
        System.out.println(" 5. Delete Contact by id   ");
        System.out.println(" 6. Exit      ");
        System.out.println(" ----------------------------------\n ");
        System.out.print("Please enter the number choice what you want to(only the selected number)\n");
        choice=Integer.parseInt(scanner.next());
        switch(choice) {
            case 1:{
                try {
                    N.findAll();
                } catch (Exception e) {
                    System.out.println("Input is incorrect" + e.getMessage());
                }
                System.out.println("Press Enter key to continue...\n");

            }//End of case 1
            break;
            case 2:{

                System.out.print("Enter in order :>>>>>Id(Numerically):>>>>>:");
                    mylist.add(scanner.next());
                System.out.print("plz Enter :>>>>>LastName:>>>>>:");
                    mylist.add(scanner.next());
                System.out.print("plz Enter :>>>>>FirstName:>>>>>:");
                    mylist.add(scanner.next());
                System.out.print("plz Enter :>>>>>Address:>>>>>:");
                    mylist.add(scanner.next());
                System.out.print("plz Enter :>>>PhoneNumber(Numerically):>>>>>:");
                     mylist.add(scanner.next());
                try {
                   N.save(mylist);
                } catch (Exception e) {
                    System.out.println("Input is incorrect" + e.getMessage());
                }
                System.out.println("Press Enter key to continue... \n");
            }//End of case 2
            break;


          case 3:{
                System.out.print("Enter the  id,  you want to Find: \n");
                int userid=Integer.parseInt(scanner.next());
                try {
                     N.findById(userid);
                } catch (Exception e) {
                    System.out.println("Input is incorrect" + e.getMessage());
                }
                System.out.println("Press Enter key to continue...\n");
            }//End of case 3
            break;


            case 4:{
                System.out.print("Enter the Id, you want to update:  \n ");
                    p.setId(scanner.nextInt());
                 System.out.print("plz Enter:>>>>>your new FirstName:>>>>>:");
                    p.setFirstName(scanner.next());
                 System.out.print("plz Enter:>>>>>your new LastName:>>>>>:");
                    p.setLastName(scanner.next());
                 System.out.print("plz Enter:>>>>>your new Address:>>>>>:");
                    p.setAddress(scanner.next());
                 System.out.print("plz Enter:>>>>>your new PhoneNumber:>>>>>:");
                    p.setPhoneNumber(scanner.nextInt());
                try {
                   N.update(p.getId());
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
                    N.deleteP(userid);
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
