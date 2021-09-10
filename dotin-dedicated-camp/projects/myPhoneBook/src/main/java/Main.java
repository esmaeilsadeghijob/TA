import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.myMenu();
        MyStatement ms = new MyStatement();
        ms.create();
    }
}
