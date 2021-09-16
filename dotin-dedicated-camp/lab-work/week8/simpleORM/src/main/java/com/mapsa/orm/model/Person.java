package com.mapsa.orm.model;

import com.mapsa.orm.main.Execute;
import com.mapsa.orm.persistence.Column;
import com.mapsa.orm.persistence.GeneratedValue;
import com.mapsa.orm.persistence.Id;
import com.mapsa.orm.persistence.Table;

@Table
public class Person {
    @Id
    @GeneratedValue(generator = "person_seq")
    @Column(name = "ID", dataType = "NUMBER")
    private long id;
    @Column(name = "FIRST_NAME", dataType = "VARCHAR2",length = 20)
    private String name;
    @Column(name = "LAST_NAME", dataType = "VARCHAR2")
    private String family;

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    @Override
    public String toString() {
        String str = Execute.ANSI_YELLOW +"Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                '}';
        System.out.println(str);
        return str;
    }
}
