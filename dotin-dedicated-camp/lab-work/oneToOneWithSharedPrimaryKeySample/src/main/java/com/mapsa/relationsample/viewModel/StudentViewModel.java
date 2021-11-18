package com.mapsa.relationsample.viewModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class StudentViewModel {
    private int id;
    private String name;
    private Set<SelectedCourses> selectedCourses;
    private Set<CourseRating> courseRatings;

    public StudentViewModel() {
    }

    public StudentViewModel(int id, String name, Set<SelectedCourses> selectedCourses, Set<CourseRating> courseRatings) {
        this.id = id;
        this.name = name;
        this.selectedCourses = selectedCourses;
        this.courseRatings = courseRatings;
    }

    @Getter
    @Setter
    public static class SelectedCourses {
        private int id;
        private String name;

        public SelectedCourses() {
        }

        public SelectedCourses(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Getter
    @Setter
    public static class CourseRating {
        private int rating;

        public CourseRating() {
        }

        public CourseRating(int rating) {
            this.rating = rating;
        }
    }
}
