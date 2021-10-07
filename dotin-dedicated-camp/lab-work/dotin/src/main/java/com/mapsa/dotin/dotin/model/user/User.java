package com.mapsa.dotin.dotin.model.user;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
private String id;
private String role;
private String username;
private String password;
private String firstName;
private String lastName;
private String fatherName;
// They made me to put it there it's non-sense
private String motherName;
// else is ok
private String nationalCode;
private String phoneNumber;
private String emailAddress;
}
