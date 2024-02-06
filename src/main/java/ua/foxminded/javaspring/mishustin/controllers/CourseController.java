package ua.foxminded.javaspring.mishustin.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.foxminded.javaspring.mishustin.model.Course;
import ua.foxminded.javaspring.mishustin.service.CourseService;

@Controller
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String showCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/courses/{courseId}")
    public String showCourseDetails(@PathVariable Integer courseId, Model model) {
        Optional<Course> course = courseService.getCourseById(courseId);
        model.addAttribute("course", course.orElse(null));
        return "course-details";
    }
}
