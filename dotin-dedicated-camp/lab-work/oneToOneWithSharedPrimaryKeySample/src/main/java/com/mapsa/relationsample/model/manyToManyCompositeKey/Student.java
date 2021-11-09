package com.mapsa.relationsample.model.manyToManyCompositeKey;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student {
    @ManyToMany
    @JoinTable(
            name = "course_selected",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    Set<Course> selectedCourses;
    @OneToMany(mappedBy = "student")
    Set<CourseRating> courseRatings;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    protected Student(){}

    public Student(String name) {
        setName(name);
    }

}
