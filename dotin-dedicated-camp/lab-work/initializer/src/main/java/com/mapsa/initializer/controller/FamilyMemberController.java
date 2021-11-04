package com.mapsa.initializer.controller;

import com.mapsa.initializer.model.FamilyMember;
import com.mapsa.initializer.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/mapsa/family-member")
public class FamilyMemberController {
    @Autowired
    private FamilyMemberService service;

    @GetMapping("all")
    public Set<FamilyMember> getAll() {
        return service.getAll();
    }

    @PostMapping("save")
    public FamilyMember save(@RequestBody FamilyMember member) {
        return service.save(member);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("findBy/{id}")
    public FamilyMember findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("findAllByPersonnel/{id}")
    public Set<FamilyMember> findAllByIdPersonnel(@PathVariable Long id) {
        return service.findAllByPersonnelId(id);
    }
}
