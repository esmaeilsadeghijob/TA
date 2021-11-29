package com.mapsa.security.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String username;
    private String password;
}
