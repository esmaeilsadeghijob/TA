package com.mapsa.relationsample.model.oneToOneWithSharedPrimaryKey;

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

    private String firstname;
    public String lastname;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    // mappedBy value points to the relationship owner
    // @oneToOne defines a one-to-one relationship between 2 entities
    private IDCard idCard;

    public Person(String firstname, String lastname, IDCard idCard) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.idCard = idCard;
        this.idCard.setPerson(this);
    }

    protected Person() {
    }
}
