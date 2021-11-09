package com.mapsa.relationsample.repository.manyToManyCompositeKey;

import com.mapsa.relationsample.model.manyToManyCompositeKey.CourseRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRatingRepository extends JpaRepository<CourseRating, Integer> {
}
