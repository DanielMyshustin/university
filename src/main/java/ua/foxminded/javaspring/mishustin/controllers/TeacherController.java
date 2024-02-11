package ua.foxminded.javaspring.mishustin.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.foxminded.javaspring.mishustin.model.Teacher;
import ua.foxminded.javaspring.mishustin.service.TeacherService;

@Controller
public class TeacherController {

	private final TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@GetMapping("/teacher-page")
	public String showTeachers(Model model) {
		model.addAttribute("teachers", teacherService.getAllTeachers());
		return "teachers";
	}

	@GetMapping("/teachers/{teacherId}")
	public String showTeacherDetails(@PathVariable Integer teacherId, Model model) {
		Optional<Teacher> teacher = teacherService.getTeacherById(teacherId);
		model.addAttribute("teacher", teacher);
		return "teacher-details";
	}
}
