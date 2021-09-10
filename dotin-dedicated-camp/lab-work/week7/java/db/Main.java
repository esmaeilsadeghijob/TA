package com.mapsa.Mybook.db;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
//        DBconnection dBconnection = new DBconnection();
//        Person saj = new Person();
//        saj.setName("Alok");
//        saj.setId(8);
//        saj.setName("MBA");
//        saj.setLastName("Serajzadeh");
////        Student tinkoo = new Student();
////        tinkoo.setName("Arvind");
////        tinkoo.setRollNo(6);
//        // Adding Data
//        saj.add(saj);
//        // Deleting Data
//        sajjad.delete(7);
//        // Updating Data
//        student.update(tinkoo);
//        // Displaying Data
//        student.findAll();

//    }
        PersonDAOJDBC personDAOJDBC = new PersonDAOJDBC();
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("kian");
        p1.setLastName("Khalili");
        p1.setPhoneNumber(333456);
        personDAOJDBC.add(p1);
        personDAOJDBC.update(p1);
        personDAOJDBC.showAll();

    }
}
