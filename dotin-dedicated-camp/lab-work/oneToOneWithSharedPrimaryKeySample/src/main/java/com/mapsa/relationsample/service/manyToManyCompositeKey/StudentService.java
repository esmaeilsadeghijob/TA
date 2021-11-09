package com.mapsa.relationsample.service.manyToManyCompositeKey;

import com.mapsa.relationsample.model.manyToManyCompositeKey.Course;
import com.mapsa.relationsample.model.manyToManyCompositeKey.Student;
import com.mapsa.relationsample.repository.manyToManyCompositeKey.CourseRepository;
import com.mapsa.relationsample.repository.manyToManyCompositeKey.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    @Autowired
    private CourseRepository courseRepository;

    public void save(String name) {
        repository.save(new Student(name));
    }

    public Student addCourse(int studentId, int courseId){
        Student student = repository.findById(studentId).orElse(null);
        assert student != null;
        Set<Course> selectedCourses = student.getSelectedCourses();
        if (selectedCourses == null) {
            selectedCourses = new HashSet<>();
        }
        Course course = courseRepository.findById(courseId).orElse(null);
        assert course != null;
        selectedCourses.add(course);
        return repository.save(student);
    }

    public List<Student> getAll(){
        return repository.findAll();
    }
}
