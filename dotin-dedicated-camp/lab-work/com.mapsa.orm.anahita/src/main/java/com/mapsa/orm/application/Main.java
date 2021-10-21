package com.mapsa.orm.application;

import com.mapsa.orm.crud.CrudImp;
import com.mapsa.orm.model.Car;
import com.mapsa.orm.model.Person;

public class Main {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Person person2 = new Person(1,"ana", "makvandi");
        //Person person = new Person(1,"maryam","pourbaqer");
        //Person person2 = new Person(2,"anahita","makvandi");
       // person2.setFirstName("shokoufeh");
       // Person person3 = new Person(3,"atoosa","makvandi");
        CrudImp crudImp = new CrudImp(person.getClass());
        CrudImp crudImp2 = new CrudImp(person.getClass());
        Car car = new Car();
       // crudImp.update(person2,1);
        //crudImp.create(person);
        //crudImp2.create(car);
        crudImp.addRecord(person2);
      //  crudImp.deleteRow(person,1);
//        try {
//            crudImp.addRecord(person);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//        Connection connection;
//        try {
//            connection = ConnectionToDB.getConnectionToDB();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        //       Person person = new Person(1,"anahita", "makvandi");
//        CRUDImp crudImp = new CRUDImp(person);
//        try {
//            // crudImp.create();
//            crudImp.addRow(person);
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }
}

