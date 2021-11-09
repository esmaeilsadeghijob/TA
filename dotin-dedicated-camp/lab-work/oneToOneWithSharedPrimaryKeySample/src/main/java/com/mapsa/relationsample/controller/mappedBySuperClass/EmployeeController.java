package com.mapsa.relationsample.controller.mappedBySuperClass;

import com.mapsa.relationsample.param.EmployeeParame;
import com.mapsa.relationsample.model.mappedBySuperClass.Employee;
import com.mapsa.relationsample.service.mappedBySuperClass.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("save")
    public void save(@RequestBody EmployeeParame parame) {
        service.save(parame.getFirstname(), parame.getLastname(), parame.getCompany());
    }

    @GetMapping("all")
    public List<Employee> getAll() {
        return service.getAll();
    }
}
