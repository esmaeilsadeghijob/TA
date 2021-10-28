package com.mapsa.dotin01.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dotin.user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String fatherName;

    @Column
    private String birthday;

    @Column
    private int age;

    @Column
    private String nationalCode;

    @Column
    private String emailAddress;

    @Column
    private String phoneNumber;
}
