package ua.foxminded.javaspring.mishustin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.foxminded.javaspring.mishustin.dao.CourseRepository;
import ua.foxminded.javaspring.mishustin.model.Course;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Integer courseId) {
        return courseRepository.findById(courseId);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Integer courseId, Course updatedCourse) {
        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if (existingCourse.isPresent()) {
            updatedCourse.setCourseId(courseId);
            return courseRepository.save(updatedCourse);
        } else {
            return null;
        }
    }

    public void deleteCourse(Integer courseId) {
        courseRepository.deleteById(courseId);
    }
}