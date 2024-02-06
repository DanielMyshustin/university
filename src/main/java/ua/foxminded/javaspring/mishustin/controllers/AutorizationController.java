package ua.foxminded.javaspring.mishustin.controllers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutorizationController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                currentUser.login(token);
            } catch (AuthenticationException e) {
                return "redirect:/login?error=true";
            }
        }

        if (currentUser.hasRole("TEACHER")) {
            return "redirect:/teacher-page";
        } else if (currentUser.hasRole("STUDENT")) {
            return "redirect:/student-page";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}