package com.mapsa.relationsample.repository.manyToManyCompositeKey;

import com.mapsa.relationsample.model.manyToManyCompositeKey.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
