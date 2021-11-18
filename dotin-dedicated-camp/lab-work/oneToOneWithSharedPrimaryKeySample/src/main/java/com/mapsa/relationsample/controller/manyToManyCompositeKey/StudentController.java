package com.mapsa.relationsample.controller.manyToManyCompositeKey;

import com.mapsa.relationsample.model.manyToManyCompositeKey.Student;
import com.mapsa.relationsample.service.manyToManyCompositeKey.StudentService;
import com.mapsa.relationsample.viewModel.StudentViewModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService service;

    private ModelMapper modelMapper;


    @PostMapping("save")
    public void save(@RequestParam String name) {
        service.save(name);
    }

    @PostMapping("add")
    public StudentViewModel addCourse(@RequestParam("studentId") int studentId,
                                      @RequestParam("courseId") int courseId) {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(service.addCourse(studentId, courseId), StudentViewModel.class);
    }

    @GetMapping("all")
    public Set<StudentViewModel> getAll() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        List<Student> all = service.getAll();
        return modelMapper.map(all, new TypeToken<Set<StudentViewModel>>() {
        }.getType());
    }
}
