package com.niloofar.orm.model;

import com.niloofar.orm.persistence.Coloumn;
import com.niloofar.orm.persistence.Id;
import com.niloofar.orm.persistence.Table;

@Table(name = "niloo1")
public class Student {

    @Coloumn(name = "name", dataType = "VARCHAR")
    private String name;
    @Id
    @Coloumn(name = "ID", dataType = "INTEGER")
    private int id;
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
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]" ;

    }
}
