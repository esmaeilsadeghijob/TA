package com.mapsa.relationsample.controller.manyToManyCompositeKey;

import com.mapsa.relationsample.model.manyToManyCompositeKey.CourseRating;
import com.mapsa.relationsample.service.manyToManyCompositeKey.CourseRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course/rating")
public class CourseRatingController {
    @Autowired
    private CourseRatingService service;

    @PostMapping("save")
    public void save(@RequestParam("rating") int rating,
                     @RequestParam("studentId") int studentId,
                     @RequestParam("courseId") int courseId) {
        service.save(rating, studentId, courseId);
    }

    @GetMapping("all")
    public List<CourseRating> getAll() {
        return service.getAll();
    }
}
