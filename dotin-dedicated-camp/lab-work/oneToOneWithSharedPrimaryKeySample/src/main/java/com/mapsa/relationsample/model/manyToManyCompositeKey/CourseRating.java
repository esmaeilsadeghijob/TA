package com.mapsa.relationsample.model.manyToManyCompositeKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CourseRating {
    @EmbeddedId
    private CourseRatingKey key;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    private int rating;

    protected CourseRating(){}

    public CourseRating(int rating, int studentId, int courseId) {
        this.course = new Course();
        this.student = new Student();
        this.key = new CourseRatingKey();
        this.course.setId(courseId);
        this.student.setId(studentId);
        key.courseId = courseId;
        key.studentId = studentId;
        this.setRating(rating);
    }
}
