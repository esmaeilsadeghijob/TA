package com.mapsa.springDataJPASample.repository;

import com.mapsa.springDataJPASample.model.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
    @Query(" from FamilyMember mem " +
            "where mem.personnel.id = ?1 ")
    List<FamilyMember> findAllByPersonnelId(Long personnelId);

    //public List<FamilyMember> findAllByPersonnelId(Long personnelId);
}
