import DB.ActOfDB;
import DB.Person;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Person p=new Person();
        ActOfDB actOfDB=new ActOfDB();
        actOfDB.creat(p);
    }
}
