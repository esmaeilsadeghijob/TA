package com.niloofar.orm;

import com.niloofar.orm.JDBC.DaoImplementation;
import com.niloofar.orm.JDBC.JDBCSingleton;
import com.niloofar.orm.JDBC.TableName;
import com.niloofar.orm.model.Person;

import java.sql.SQLException;
import java.util.ArrayList;


public class MyApplication {
    public static void main(String[] args) throws SQLException {
        Person p=new Person();
        JDBCSingleton jdbc = JDBCSingleton.getInstance();
        DaoImplementation generator = new DaoImplementation();
    //    ArrayList<String> mylist = new ArrayList<>();

     //  generator.creat(new Person());
   //   p.setName("666");
    //      mylist.add("nnn");
         // generator.add(p);
           //  generator.getAll(p);
    //     p.setId(2);
// generator.alter(p, TableName.users);
      //  generator.delete(p,1);
      // generator.update(p,2);
// generator.getAll(p);


    }
}
