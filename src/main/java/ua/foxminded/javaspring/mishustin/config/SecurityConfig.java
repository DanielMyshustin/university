package ua.foxminded.javaspring.mishustin.config;
 
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.foxminded.javaspring.mishustin.security.SecurityRealm;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class SecurityConfig {
	
    private final SecurityRealm securityRealm;
	
    @Autowired
	public SecurityConfig(SecurityRealm securityRealm) {
		this.securityRealm = securityRealm;
	}

	@Bean(name = "customSecurityManager")
	public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(securityRealm);
        // Другие настройки...

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/public/", "anon");
        filterChainDefinitionMap.put("/teacher/", "authc, roles[TEACHER]");
        filterChainDefinitionMap.put("/student/", "authc, roles[STUDENT]");
        filterChainDefinitionMap.put("/", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // Добавим конфигурацию перенаправления на страницу учителя
        Map<String, String> filterChainDefinitionMapWithRoles = new LinkedHashMap<>(filterChainDefinitionMap);
        filterChainDefinitionMapWithRoles.put("/teacher-page", "authc, roles[TEACHER]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMapWithRoles);

        return shiroFilterFactoryBean;
    }
}