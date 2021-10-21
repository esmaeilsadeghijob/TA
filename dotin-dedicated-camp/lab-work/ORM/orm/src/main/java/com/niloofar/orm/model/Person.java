package com.niloofar.orm.model;

import com.niloofar.orm.persistence.*;

@Table(name = "userdata1")
public class Person {

    @Id
    @Coloumn(name = "Id", dataType = "INTEGER",des = "NOT NULL AUTO_INCREMENT")
    private int id;
    @Coloumn(name = "name", dataType = "VARCHAR")
    private String name;

    @ForeignKEY
    @Coloumn(name = "column_3", dataType = "VARCHAR")
    private int column_3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]" ;

    }
}
