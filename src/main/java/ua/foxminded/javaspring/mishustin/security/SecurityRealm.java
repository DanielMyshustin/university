package ua.foxminded.javaspring.mishustin.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.mishustin.model.Teacher;
import ua.foxminded.javaspring.mishustin.service.TeacherService;

import java.util.Optional;

@Component
public class SecurityRealm extends AuthorizingRealm {

    @Autowired
    private TeacherService teacherService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        Optional<Teacher> optionalTeacher = teacherService.findByLogin(username);

        if (!optionalTeacher.isPresent()) {
            throw new UnknownAccountException("User not found with username: " + username);
        }

        Teacher teacher = optionalTeacher.get();
        String password = teacher.getPassword();

        return new SimpleAuthenticationInfo(username, password, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        Optional<Teacher> optionalTeacher = teacherService.findByLogin(username);

        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            String role = teacher.getRole();

            if (role != null) {
                SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
                authorizationInfo.addRole(role);
                return authorizationInfo;
            }
        }
        return null;
    }
}
