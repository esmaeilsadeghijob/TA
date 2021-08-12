
import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("firstname ra varde konid");
        String name = input.next();
        person n = new person() {
            @Override
            public void delete() {

            }

            @Override
            public void save() {

            }

            @Override
            public void add() {

            }

            @Override
            public void select() {

            }
        };

  n.setFirstName(name);
  n.setPassword("1234");
        System.out.println("id ra varde konid");
       String id = input.next();
        n.setId(id);
        System.out.println("phone ra varde konid");
        int phone=input.nextInt();
        n.setPhoneNumber(phone);
        System.out.println("sabt shod");
    }
}
