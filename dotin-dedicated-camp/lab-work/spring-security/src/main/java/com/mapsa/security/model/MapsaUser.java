package com.mapsa.security.model;

import com.mapsa.security.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class MapsaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    private String username;
    private String password;
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    protected MapsaUser() {
    }
}
