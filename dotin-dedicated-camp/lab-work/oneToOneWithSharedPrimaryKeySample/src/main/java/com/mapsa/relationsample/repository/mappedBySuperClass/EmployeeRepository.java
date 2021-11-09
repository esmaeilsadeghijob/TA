package com.mapsa.relationsample.repository.mappedBySuperClass;

import com.mapsa.relationsample.model.mappedBySuperClass.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
