package com.mapsa.relationsample.model.mappedBySuperClass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Employee extends Human {
    private String company;

    private Employee() {
    }

    public Employee(String firstname, String lastname, String company) {
        this.company = company;
        setFirstname(firstname);
        setLastname(lastname);
    }
}
