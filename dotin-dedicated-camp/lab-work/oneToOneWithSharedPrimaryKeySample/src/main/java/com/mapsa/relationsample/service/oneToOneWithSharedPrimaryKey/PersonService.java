package com.mapsa.relationsample.service.oneToOneWithSharedPrimaryKey;

import com.mapsa.relationsample.dto.PersonDTO;
import com.mapsa.relationsample.model.oneToOneWithSharedPrimaryKey.IDCard;
import com.mapsa.relationsample.model.oneToOneWithSharedPrimaryKey.Person;
import com.mapsa.relationsample.repository.oneToOneWithSharedPrimaryKey.PersonRepository;
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
