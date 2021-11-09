package com.mapsa.springDataJPASample.service;

import com.mapsa.springDataJPASample.model.FamilyMember;
import com.mapsa.springDataJPASample.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FamilyMemberService {
    @Autowired
    private FamilyMemberRepository repository;

    public FamilyMember save(FamilyMember familyMember) {
        return repository.save(familyMember);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Set<FamilyMember> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    public FamilyMember findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Set<FamilyMember> findAllByPersonnelId(Long personnelId) {
        return repository.findAllByPersonnelId(personnelId).stream().collect(Collectors.toSet());
    }
}
