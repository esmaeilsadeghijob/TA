import java.sql.*;
import java.util.Scanner;

public class MyStatement {
    Scanner sc;
    Statement statement;
    User user;

    public MyStatement() throws SQLException {
        sc = new Scanner(System.in);
        Connection conn = ConnectionToDB.getMyConnection();
        statement = conn.createStatement();
        user = new User();
    }


    public void create(){

        System.out.println("enter id: ");
        int id = sc.nextInt();
        user.setId(id);
        System.out.println("enter firstName: ");
        String firstName = sc.next();
        user.setFirstName(firstName);
        System.out.println("enter lastName: ");
        String lastName = sc.next();
        user.setLastName(lastName);
        System.out.println("enter phoneNumber: ");
        String phoneNumber = sc.next();
        user.setPhoneNumber(phoneNumber);
        user = new User(user.getId(),user.getFirstName(),user.getLastName(),user.getPhoneNumber());

        String sql = "INSERT INTO User (id, firstName, lastName, phoneNumber) VALUES (";
        String sql2 = id + ",' " + firstName + "','" + lastName + "','" + phoneNumber +"')";
        String mysql = sql + sql2;
        System.out.println(mysql);
        try {
            statement.execute(mysql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update() throws SQLException {
        System.out.println("please enter the id that you wanna update it's fields. ");
        int id = sc.nextInt();
        user.setId(id);
        System.out.println("enter updated firstName: ");
        String firstName = sc.next();
        user.setFirstName(firstName);
        System.out.println("enter updated firstName: ");
        String lastName = sc.next();
        user.setLastName(lastName);
        System.out.println("enter updated firstName: ");
        String phoneNumber = sc.next();
        user.setPhoneNumber(phoneNumber);
        String usql = "UPDATE myphonebook.user SET firstName = " + "'" + user.getFirstName() + "'" + ", lastName = " + "'" + user.getLastName()
                + "'" + ",phoneNumber = " + "'" + user.getPhoneNumber() + "'" + " where id = " + user.getId();
        int updated = statement.executeUpdate(usql);
        System.out.println(updated);
    }

    public void delete() throws SQLException {
        System.out.println("please enter the id that yo want to delete.");
        int id = sc.nextInt();
        user.setId(id);

        String dsql =  "select id, firstName, lastName, phoneNumber from myphonebook.user where id = " + user.getId();
        int deleted = statement.executeUpdate(dsql);
        System.out.println(deleted);
    }

    public void serach() {
        System.out.println("please enter how many rows you wanna see");
    }

}
