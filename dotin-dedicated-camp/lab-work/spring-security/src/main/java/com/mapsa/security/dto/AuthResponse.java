package com.mapsa.security.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true, fluent = true)
public class AuthResponse {
    private String username;
    private String jwtToken;
}
