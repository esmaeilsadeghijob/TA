package com.mapsa.security.repository;

import com.mapsa.security.model.MapsaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MapsaUserRepository extends JpaRepository<MapsaUser, Long> {
    Optional<MapsaUser> findMapsaUserByUsername(String username);
}
