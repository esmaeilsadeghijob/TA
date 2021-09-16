package com.mapsa.orm.model;

import com.mapsa.orm.annotation.Column;
import com.mapsa.orm.annotation.Id;
import com.mapsa.orm.annotation.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Table(name = "Person")
public class Person implements Objects {

    @Id
    @Column(name = "ID", dataType = "INTEGER")
    private int id;
    @Column(name = "firstname", dataType = "VARCHAR")
    private String firstName;
    @Column(name = "lastname", dataType = "VARCHAR")
    private String lastName;

    @Override
    public void display() {
        System.out.println("id " + getFirstName() + " First Name: " + getFirstName() + " Last Name " + getLastName());
    }

}
