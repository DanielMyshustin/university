package ua.foxminded.javaspring.mishustin.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String mainMenu() {
		return "mainMenu";
	}
}
