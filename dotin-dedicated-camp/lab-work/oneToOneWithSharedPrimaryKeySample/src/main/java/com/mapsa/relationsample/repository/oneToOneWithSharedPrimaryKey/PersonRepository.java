package com.mapsa.relationsample.repository.oneToOneWithSharedPrimaryKey;

import com.mapsa.relationsample.dto.PersonDTO;
import com.mapsa.relationsample.model.oneToOneWithSharedPrimaryKey.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    public List<PersonDTO> getAllByFirstnameIsNotNull();
}
