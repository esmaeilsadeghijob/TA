package com.mapsa.relationsample.repository.manyToManyCompositeKey;

import com.mapsa.relationsample.model.manyToManyCompositeKey.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
