import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Queries q=new Queries();
        List<Integer> id=new ArrayList<Integer>();
        System.out.println("choose on of:"+"\n"+"select,delete,update,insert");
        Scanner s=new Scanner(System.in);
        String s1=s.next();

        if(s1.equalsIgnoreCase("select")){
            System.out.println("pls enter id:");
            while(s.nextInt()!=-1){
                id.add(s.nextInt());
            }
            try {
                q.select(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if(s1.equalsIgnoreCase("delete")){
            int idd;
            System.out.println("pls enter id:");
            idd=s.nextInt();
            q.delete(idd);
        }else if(s1.equalsIgnoreCase("insert")){
            System.out.println("pls enter id,name,family,phonenumber:");
            int idi=s.nextInt();
            String namei=s.next();
            String familyi=s.next();
            String phonei=s.next();
            Person p = new Person(idi,namei,familyi,phonei);
            q.insert(p);
        }else if(s1.equalsIgnoreCase("update")){
            System.out.println("pls enter old id:");
            int id1=s.nextInt();
            System.out.println("pls enter new name,family,phonenumber:");
            String name2=s.next();
            String family2=s.next();
            String phone2=s.next();
            Person p=new Person(id1,name2,family2,phone2);
            q.update(p);
        }

    }
}
