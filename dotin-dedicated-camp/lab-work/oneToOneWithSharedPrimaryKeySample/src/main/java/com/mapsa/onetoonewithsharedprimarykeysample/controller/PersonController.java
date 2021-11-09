package com.mapsa.onetoonewithsharedprimarykeysample.controller;

import com.mapsa.onetoonewithsharedprimarykeysample.Parame;
import com.mapsa.onetoonewithsharedprimarykeysample.dto.PersonDTO;
import com.mapsa.onetoonewithsharedprimarykeysample.model.Person;
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
    public void save(@RequestBody Parame parame){
        service.save(parame.getFirstname(), parame.getLastname());
    }

    @GetMapping("all")
    public List<PersonDTO> getAll() {
        return service.getAll();
    }
}
