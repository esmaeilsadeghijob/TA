package com.niloofar.orm.model;

import com.niloofar.orm.persistence.Coloumn;
import com.niloofar.orm.persistence.Id;
import com.niloofar.orm.persistence.Table;

@Table(name = "niloo123")
public class Person {

    @Id
    @Coloumn(name = "ID", dataType = "INTEGER")
    private int id;
    @Coloumn(name = "name", dataType = "VARCHAR")
    private String name;

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
