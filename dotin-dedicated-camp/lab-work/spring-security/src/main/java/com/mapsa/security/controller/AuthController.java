package com.mapsa.security.controller;

import com.mapsa.security.auth.JwtProvider;
import com.mapsa.security.dto.AuthResponse;
import com.mapsa.security.dto.LoginRequest;
import com.mapsa.security.model.MapsaUser;
import com.mapsa.security.service.MapsaUserService;
import com.mapsa.security.service.UserDetailsServiceImpl;
import com.mapsa.security.viewModel.MapsaUserViewModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    private MapsaUserService service;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody MapsaUserViewModel model) {
        service.save(new ModelMapper().map(model, MapsaUser.class));
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken
                                      (loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getUsername());
        String token = jwtProvider.generateToken(userDetails);
        AuthResponse authResponse = new AuthResponse()
                .setUsername(userDetails.getUsername())
                .setJwtToken(token);
        return authResponse;
    }
}
