package com.mapsa.initializer.repository;

import com.mapsa.initializer.model.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
    /*@Query("select mem.personnel as personnel, mem.birthDate as birthDate, mem.firstname as firstname, " +
            "mem.lastname as lastname, " +
            "mem.gender as gender, mem.nationalCode as nationalCode, mem.phoneNumber as phoneNumber, " +
            "mem.type as type, mem.id as id from FamilyMember mem " +
            "where mem.personnel.id = ?1 ")
    List<FamilyMember> findAllByPersonnelId(Long personnelId);*/

    public List<FamilyMember> findAllByPersonnelId(Long personnelId);
}
