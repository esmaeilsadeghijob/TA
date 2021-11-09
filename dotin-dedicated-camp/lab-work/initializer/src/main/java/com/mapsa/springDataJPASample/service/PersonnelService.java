package com.mapsa.springDataJPASample.service;

import com.mapsa.springDataJPASample.model.Personnel;
import com.mapsa.springDataJPASample.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonnelService {
    @Autowired
    private PersonnelRepository repository;

    public Personnel save(Personnel personnel) {
        return repository.save(personnel);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Set<Personnel> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    public Personnel findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
