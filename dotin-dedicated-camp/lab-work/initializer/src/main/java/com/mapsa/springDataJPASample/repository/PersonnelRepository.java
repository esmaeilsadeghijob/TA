package com.mapsa.springDataJPASample.repository;

import com.mapsa.springDataJPASample.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
}
