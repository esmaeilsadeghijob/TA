package com.mapsa.relationsample.controller.manyToManyCompositeKey;

import com.mapsa.relationsample.service.manyToManyCompositeKey.CourseRatingService;
import com.mapsa.relationsample.viewModel.CourseRatingViewModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("course/rating")
public class CourseRatingController {
    @Autowired
    private CourseRatingService service;

    private ModelMapper modelMapper;

    @PostMapping("save")
    public void save(@RequestParam("rating") int rating,
                     @RequestParam("studentId") int studentId,
                     @RequestParam("courseId") int courseId) {
        service.save(rating, studentId, courseId);
    }

    @GetMapping("all")
    public List<CourseRatingViewModel> getAll() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(service.getAll(), new TypeToken<List<CourseRatingViewModel>>() {
        }.getType());
    }
}
