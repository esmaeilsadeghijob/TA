package com.mapsa.security.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    private final String SECRET = "SECRETSECRETSECRETSECRETSECRETSECRETSECRETSECRET";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> map = new HashMap<>();
        return createToken(map, userDetails);
    }

    private String createToken(Map<String, Object> map, UserDetails userDetails) {

        return Jwts.builder()
                   .setClaims(map)
                   .setSubject(userDetails.getUsername())
                   // .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2)
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .signWith(SignatureAlgorithm.HS256, SECRET) // private-key
                   .compact();
    }

    // Validation
    private Claims extractClaimsFromToken(String token) {
        return Jwts.parser()
                   .setSigningKey(SECRET)
                   .parseClaimsJws(token)
                   .getBody();
    }

    private Boolean isTokenExpired(String token) {
        Claims claims = extractClaimsFromToken(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = extractClaimsFromToken(token).getSubject();
        return userDetails.getUsername().equals(username) && !isTokenExpired(token);
    }

    public String getUsername(String token) {
        return extractClaimsFromToken(token).getSubject();
    }
}
