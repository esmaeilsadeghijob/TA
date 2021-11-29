package com.mapsa.security.service;

import com.mapsa.security.model.MapsaUser;
import com.mapsa.security.repository.MapsaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private MapsaUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MapsaUser user = repository
                .findMapsaUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No such User: " + username));
        return new User(user.getUsername(), user.getPassword(), user.getRoles());
    }
}
