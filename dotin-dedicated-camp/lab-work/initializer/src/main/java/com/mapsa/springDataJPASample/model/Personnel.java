package com.mapsa.springDataJPASample.model;

import com.mapsa.springDataJPASample.enumeration.Gender;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MAPSA_PERSONNEL")
@Data
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;
    private String lastname;
    private String birthDate;
    @Transient
    private int age;
    @Enumerated
    private Gender gender;
    private String phoneNumber;
    private String nationalCode;
}
