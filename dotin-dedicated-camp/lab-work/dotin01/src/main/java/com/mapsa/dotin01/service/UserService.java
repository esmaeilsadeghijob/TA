package com.mapsa.dotin01.service;

import com.mapsa.dotin01.model.User;
import com.mapsa.dotin01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.ELException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public User getUserById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Set<User> getAllUsers() {
        return new HashSet<>(repository.findAll());
    }

    public User updateUser(User user) {
        if (user.getId() == null || user.getId() == "") {

        } else {
            return repository.save(user);
        }
    }
}
