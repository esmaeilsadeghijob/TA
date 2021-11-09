package com.mapsa.relationsample.service.manyToManyCompositeKey;

import com.mapsa.relationsample.model.manyToManyCompositeKey.Course;
import com.mapsa.relationsample.model.manyToManyCompositeKey.CourseRating;
import com.mapsa.relationsample.repository.manyToManyCompositeKey.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public void save(String name) {
        repository.save(new Course(name));
    }

    public List<Course> getAll(){
        return repository.findAll();
    }
}
