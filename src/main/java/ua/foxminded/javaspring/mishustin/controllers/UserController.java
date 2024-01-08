package ua.foxminded.javaspring.mishustin.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.foxminded.javaspring.mishustin.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String showAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "userList";
	}

	@GetMapping("/users/{userId}")
	public String showUserDetails(@PathVariable Integer userId, Model model) {
		userService.getUserById(userId).ifPresent(user -> model.addAttribute("user", user));
		return "userDetails";
	}
}
