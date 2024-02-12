package ua.foxminded.javaspring.mishustin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import ua.foxminded.javaspring.mishustin.config.SecurityConfig;
import ua.foxminded.javaspring.mishustin.config.ShiroConfig;

@SpringBootApplication()
@Import({ShiroConfig.class, SecurityConfig.class})
@ComponentScan(basePackages = "ua.foxminded.javaspring.mishustin")
@EnableAutoConfiguration
public class UniversityScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityScheduleApplication.class, args);
	}
}
