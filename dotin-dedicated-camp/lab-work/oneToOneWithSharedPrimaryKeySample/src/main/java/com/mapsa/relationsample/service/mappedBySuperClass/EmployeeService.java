package com.mapsa.relationsample.service.mappedBySuperClass;

import com.mapsa.relationsample.model.mappedBySuperClass.Employee;
import com.mapsa.relationsample.repository.mappedBySuperClass.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public void save(String firstname, String lastname, String company) {
        repository.save(new Employee(firstname, lastname, company));
    }

    public List<Employee> getAll(){
        return repository.findAll();
    }
}
