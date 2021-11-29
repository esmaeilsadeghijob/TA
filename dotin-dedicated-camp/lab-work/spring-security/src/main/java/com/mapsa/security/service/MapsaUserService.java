package com.mapsa.security.service;

import com.mapsa.security.model.MapsaUser;
import com.mapsa.security.repository.MapsaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapsaUserService {

    private final PasswordEncoder     passwordEncoder;
    @Autowired
    private       MapsaUserRepository repository;

    public void save(MapsaUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

}
