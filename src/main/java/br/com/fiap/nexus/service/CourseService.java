package br.com.fiap.nexus.service;

import br.com.fiap.nexus.model.Course;
import br.com.fiap.nexus.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course createCourse(@Valid Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, @Valid Course course) {
        course.setId(id);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
