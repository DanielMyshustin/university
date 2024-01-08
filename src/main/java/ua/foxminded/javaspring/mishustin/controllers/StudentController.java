package ua.foxminded.javaspring.mishustin.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.foxminded.javaspring.mishustin.model.Student;
import ua.foxminded.javaspring.mishustin.service.StudentService;

import java.util.Optional;

@Controller
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String showStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/{studentId}")
	public String showStudentDetails(@PathVariable Integer studentId, Model model) {
		Optional<Student> student = studentService.getStudentById(studentId);
		model.addAttribute("student", student);
		return "student-details";
	}
}
