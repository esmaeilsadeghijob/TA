package com.mapsa.relationsample.controller.manyToManyCompositeKey;

import com.mapsa.relationsample.model.manyToManyCompositeKey.Course;
import com.mapsa.relationsample.service.manyToManyCompositeKey.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService service;


    @PostMapping("save")
    public void save(@RequestParam String name) {
        service.save(name);
    }

    @GetMapping("all")
    public List<Course> getAll() {
        return service.getAll();
    }
}
