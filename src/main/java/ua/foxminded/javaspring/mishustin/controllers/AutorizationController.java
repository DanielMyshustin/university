package ua.foxminded.javaspring.mishustin.controllers;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutorizationController {

    @Autowired
    private SecurityManager securityManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        SecurityUtils.setSecurityManager(securityManager);
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
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}