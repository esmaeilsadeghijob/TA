package com.mapsa.dotin01.repository;

import com.mapsa.dotin01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User getAllByAge(int age);
}
