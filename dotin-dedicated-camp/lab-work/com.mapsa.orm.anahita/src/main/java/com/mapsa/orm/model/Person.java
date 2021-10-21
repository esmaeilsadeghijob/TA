package com.mapsa.orm.model;

import com.mapsa.orm.annotations.Column;
import com.mapsa.orm.annotations.Key;
import com.mapsa.orm.annotations.Table;

@Table(name = "person")
public class Person {
    @Key()
    @Column()
    private int id;
    @Column()
    private String firstName;
    @Column()
    private String lastName;

    public Person() {
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
