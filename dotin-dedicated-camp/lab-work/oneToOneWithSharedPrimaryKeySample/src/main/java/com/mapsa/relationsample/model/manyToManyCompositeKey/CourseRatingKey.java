package com.mapsa.relationsample.model.manyToManyCompositeKey;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class CourseRatingKey implements Serializable {

    @Column(name = "student_id")
    int studentId;

    @Column(name = "course_id")
    int courseId;
}
