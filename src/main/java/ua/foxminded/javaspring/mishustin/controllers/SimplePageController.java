package ua.foxminded.javaspring.mishustin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimplePageController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello University");
        return "hello";
    }
}
