package com.mapsa.initializer.controller;

import com.mapsa.initializer.model.Personnel;
import com.mapsa.initializer.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/mapsa/personnel")
public class PersonnelController {
    @Autowired
    private PersonnelService service;


    @GetMapping("all")
    public Set<Personnel> getAll() {
        return service.getAll();
    }

    @PostMapping("save")
    public Personnel save(@RequestBody Personnel personnel) {
        return service.save(personnel);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("findBy/{id}")
    public Personnel findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
