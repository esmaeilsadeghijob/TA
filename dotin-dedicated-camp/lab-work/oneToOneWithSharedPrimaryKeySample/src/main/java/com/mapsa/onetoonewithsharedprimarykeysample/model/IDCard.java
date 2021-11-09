package com.mapsa.onetoonewithsharedprimarykeysample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class IDCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, optional = false) //defines a one-to-one relationship between 2 entities
    @JoinColumn(name = "person_id") // defines a foreign key column
    @MapsId // maps to the parent entity primary key
    private Person person;

    @Column(unique = true, nullable = false) //enforces the unique constraint
    private String code = UUID.randomUUID().toString();
}
