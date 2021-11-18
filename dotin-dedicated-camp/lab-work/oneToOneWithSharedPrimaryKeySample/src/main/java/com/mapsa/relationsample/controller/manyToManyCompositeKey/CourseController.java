package com.mapsa.relationsample.controller.manyToManyCompositeKey;

import com.mapsa.relationsample.service.manyToManyCompositeKey.CourseService;
import com.mapsa.relationsample.viewModel.CourseViewModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService service;

    private ModelMapper modelMapper;

    @PostMapping("save")
    public void save(@RequestParam String name) {
        service.save(name);
    }

    @GetMapping("all")
    public List<CourseViewModel> getAll() {
        modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(service.getAll(), new TypeToken<List<CourseViewModel>>() {
        }.getType());
    }
}
