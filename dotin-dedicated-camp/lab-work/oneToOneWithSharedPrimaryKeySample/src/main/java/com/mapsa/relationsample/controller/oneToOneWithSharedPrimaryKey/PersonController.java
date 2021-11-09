package com.mapsa.relationsample.controller.oneToOneWithSharedPrimaryKey;

import com.mapsa.relationsample.param.PersonParame;
import com.mapsa.relationsample.dto.PersonDTO;
import com.mapsa.relationsample.service.oneToOneWithSharedPrimaryKey.PersonService;
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
