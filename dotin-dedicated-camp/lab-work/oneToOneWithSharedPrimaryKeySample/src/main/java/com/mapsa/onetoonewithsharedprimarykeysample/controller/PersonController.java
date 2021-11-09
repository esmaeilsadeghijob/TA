package com.mapsa.onetoonewithsharedprimarykeysample.controller;

import com.mapsa.onetoonewithsharedprimarykeysample.PersonParame;
import com.mapsa.onetoonewithsharedprimarykeysample.dto.PersonDTO;
import com.mapsa.onetoonewithsharedprimarykeysample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("oneToOne")
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping("save")
    public void save(@RequestBody PersonParame personParame){
        service.save(personParame.getFirstname(), personParame.getLastname());
    }

    @GetMapping("all")
    public List<PersonDTO> getAll() {
        return service.getAll();
    }
}
