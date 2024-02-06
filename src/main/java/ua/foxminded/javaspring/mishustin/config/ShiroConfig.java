package ua.foxminded.javaspring.mishustin.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import ua.foxminded.javaspring.mishustin.security.SecurityRealm;

@Configuration
@Import(SecurityConfig.class)
@SuppressFBWarnings(value = "URF_UNREAD_FIELD", justification = "Field is injected by Spring")
public class ShiroConfig {

	@Autowired
	private final SecurityRealm securityRealm;

	@Autowired
	public ShiroConfig(SecurityRealm securityRealm) {
		this.securityRealm = securityRealm;
	}

	@Bean
	public DefaultWebSecurityManager securityManager(SecurityRealm realm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(realm);
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
	
	@SuppressWarnings("unused")
	public ShiroConfig() {
		this.securityRealm = null;
	}
}