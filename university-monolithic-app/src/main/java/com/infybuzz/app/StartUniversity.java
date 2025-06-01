package com.infybuzz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @SpringBootApplication: Marks this as the main Spring Boot application class, enabling auto-configuration and component scanning.
// @ComponentScan: Scans specified packages for Spring-managed beans (controllers, services, configs).
// @EntityScan: Scans the specified package for JPA entity classes.
// @EnableJpaRepositories: Scans the specified package for JPA repository interfaces and enables their use.

@SpringBootApplication
@ComponentScan({ "com.infybuzz.controller", "com.infybuzz.service", "com.infybuzz.config" })
@EntityScan("com.infybuzz.entity")
@EnableJpaRepositories("com.infybuzz.repository")
public class StartUniversity {

	public static void main(String[] args) {
		SpringApplication.run(StartUniversity.class, args);
	}

}
