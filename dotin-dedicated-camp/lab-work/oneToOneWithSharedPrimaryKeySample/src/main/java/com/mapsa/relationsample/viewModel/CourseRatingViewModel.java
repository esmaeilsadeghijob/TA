package com.mapsa.relationsample.viewModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourseRatingViewModel {
    private Student student;
    private Course course;
    private int rating;

    public CourseRatingViewModel() {
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Course {
        private int id;

        public Course() {
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Student {
        private int id;

        public Student() {
        }
    }
}
