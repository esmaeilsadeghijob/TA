package com.mapsa.relationsample.service.manyToManyCompositeKey;

import com.mapsa.relationsample.model.manyToManyCompositeKey.Course;
import com.mapsa.relationsample.model.manyToManyCompositeKey.CourseRating;
import com.mapsa.relationsample.model.mappedBySuperClass.Employee;
import com.mapsa.relationsample.repository.manyToManyCompositeKey.CourseRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseRatingService {
    @Autowired
    private CourseRatingRepository repository;

    public void save(int rating, int studentId, int courseId) {
        repository.save(new CourseRating(rating,studentId,courseId));
    }

    public List<CourseRating> getAll(){
        return repository.findAll();
    }
}
