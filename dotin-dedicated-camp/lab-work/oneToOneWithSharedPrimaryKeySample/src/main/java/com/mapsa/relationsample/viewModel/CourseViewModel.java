package com.mapsa.relationsample.viewModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class CourseViewModel {
    private int id;
    private String name;
    private Set<Students> students;
    private Set<CourseRatings> courseRatings;

    public CourseViewModel() {
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Students {
        private int id;
        private String name;

        public Students() {
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CourseRatings {
        private int rating;

        public CourseRatings() {
        }
    }
}
