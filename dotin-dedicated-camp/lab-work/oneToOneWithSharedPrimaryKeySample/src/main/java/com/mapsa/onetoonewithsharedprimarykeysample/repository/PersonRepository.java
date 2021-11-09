package com.mapsa.onetoonewithsharedprimarykeysample.repository;

import com.mapsa.onetoonewithsharedprimarykeysample.dto.PersonDTO;
import com.mapsa.onetoonewithsharedprimarykeysample.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    public List<PersonDTO> getAllByFirstnameIsNotNull();
}
