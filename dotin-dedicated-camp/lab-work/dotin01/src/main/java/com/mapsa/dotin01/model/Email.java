package com.mapsa.dotin01.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dotin.email")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String subject;
    private String body;
    private HashMap<String, String> receiversAddress;

    @Enumerated
    private EmailStatus status;
}
