package com.mapsa.springDataJPASample.model;

import com.mapsa.springDataJPASample.enumeration.Gender;
import com.mapsa.springDataJPASample.enumeration.MemberType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MAPSA_FAMILY_MEMBER")
@Data
public class FamilyMember {
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAPSA_PERSONNEL_ID", nullable = false)
    private Personnel personnel;
    @Enumerated
    private MemberType type;
}
