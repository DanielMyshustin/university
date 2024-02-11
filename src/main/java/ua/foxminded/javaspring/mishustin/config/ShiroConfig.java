package ua.foxminded.javaspring.mishustin.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm; // Импортируйте IniRealm
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import ua.foxminded.javaspring.mishustin.config.SecurityConfig;

@Configuration
@Import(SecurityConfig.class)
@SuppressFBWarnings(value = "URF_UNREAD_FIELD", justification = "Field is injected by Spring")
public class ShiroConfig {

	@Bean(name = "customSecurityManager")
	public DefaultWebSecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(realm);
        return securityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
  
    @Bean
    public Realm realm() {
        return new IniRealm("classpath:shiro.ini");
    }
}
