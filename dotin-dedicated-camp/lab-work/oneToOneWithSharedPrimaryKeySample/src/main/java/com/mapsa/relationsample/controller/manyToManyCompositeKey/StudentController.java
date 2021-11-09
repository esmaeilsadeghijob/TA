package com.mapsa.relationsample.controller.manyToManyCompositeKey;

import com.mapsa.relationsample.model.manyToManyCompositeKey.Student;
import com.mapsa.relationsample.service.manyToManyCompositeKey.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService service;


    @PostMapping("save")
    public void save(@RequestParam String name) {
        service.save(name);
    }

    @PostMapping("add")
    public Student addCourse(@RequestParam("studentId") int studentId,
                             @RequestParam("courseId") int courseId) {
        return service.addCourse(studentId, courseId);
    }

    @GetMapping("all")
    public List<Student> getAll() {
        return service.getAll();
    }
}
