package com.mapsa.relationsample.model.manyToManyCompositeKey;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Course {
    @ManyToMany(mappedBy = "selectedCourses")
    Set<Student> students;
    @OneToMany(mappedBy = "course")
    Set<CourseRating> courseRatings;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Course(String name) {
        this.name = name;
    }

    protected Course() {
    }
}
