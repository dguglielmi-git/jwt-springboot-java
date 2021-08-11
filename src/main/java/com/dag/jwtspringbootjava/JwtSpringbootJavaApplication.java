package com.dag.jwtspringbootjava;

import com.dag.jwtspringbootjava.domain.Role;
import com.dag.jwtspringbootjava.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtSpringbootJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringbootJavaApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			// everything  inside of these curly braces
			// will run after the application has initialized

			// we leave id as null since it will be generated from JPA
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_ROOT"));

			userService.saveUser(new User(null, "John Travolta","john","1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith","will","1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carrey","jim","1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Arnold Schwarzenegger","arnold","1234", new ArrayList<>()));

			userService.addRoleToUser("john","ROLE_USER");
			userService.addRoleToUser("john","ROLE_MANAGER");
			userService.addRoleToUser("will","ROLE_MANAGER");
			userService.addRoleToUser("jim","ROLE_ADMIN");
			userService.addRoleToUser("arnold","ROLE_ROOT");
			userService.addRoleToUser("arnold","ROLE_ADMIN");
			userService.addRoleToUser("arnold","ROLE_USER");

		};
	}
}
