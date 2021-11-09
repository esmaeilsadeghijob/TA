package com.mapsa.onetoonewithsharedprimarykeysample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    // mappedBy value points to the relationship owner
    // @oneToOne defines a one-to-one relationship between 2 entities
    private IDCard idCard;

    public Person(String name, IDCard idCard) {
        this.name = name;
        this.idCard = idCard;
        this.idCard.setPerson(this);
    }
}
