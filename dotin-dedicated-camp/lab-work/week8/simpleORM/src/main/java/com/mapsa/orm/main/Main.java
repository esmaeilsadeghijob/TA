package com.mapsa.orm.main;

import com.mapsa.orm.database.CRUDGenerator;
import com.mapsa.orm.model.Person;

public class Main {

    public static void main(String[] args) throws Exception {

        Execute execute = new Execute();
        execute.executeApplication();

    }

   /* CRUDGenerator<Person> generator = new CRUDGenerator();
    //create table
    //generator.create(new Person());

    //insert
    Person person1 = new Person().setName("fatemeh1").setFamily("batooei1");
        generator.save(person1);

    //delete
    //generator.save(new Person().setId(1));*/

}

