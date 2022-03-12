package com.greatlearning.week9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Week8Application {

	public static void main(String[] args) {

		SpringApplication.run(Week8Application.class, args);
	}

}
