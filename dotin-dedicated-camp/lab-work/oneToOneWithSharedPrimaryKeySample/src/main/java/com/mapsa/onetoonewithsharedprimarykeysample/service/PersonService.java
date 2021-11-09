package com.mapsa.onetoonewithsharedprimarykeysample.service;

import com.mapsa.onetoonewithsharedprimarykeysample.dto.PersonDTO;
import com.mapsa.onetoonewithsharedprimarykeysample.model.IDCard;
import com.mapsa.onetoonewithsharedprimarykeysample.model.Person;
import com.mapsa.onetoonewithsharedprimarykeysample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public void save(String firstname, String lastname) {
        repository.save(new Person(firstname, lastname, new IDCard()));
    }

    public List<PersonDTO> getAll(){
        return repository.getAllByFirstnameIsNotNull();
    }
}
