package com.mapsa.onetoonewithsharedprimarykeysample.service.singleTable;

import com.mapsa.onetoonewithsharedprimarykeysample.model.singleTable.Pen;
import com.mapsa.onetoonewithsharedprimarykeysample.repository.singleTable.PenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenService {
    @Autowired
    private PenRepository repository;

    public void save(String color, String name) {
        repository.save(new Pen(color, name));
    }

    public List<Pen> getAll() {
        return repository.findAll();
    }
}
