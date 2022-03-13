package com.greatlearning.week9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class FestiveSaleApplication {

	public static void main(String[] args) {

		SpringApplication.run(FestiveSaleApplication.class, args);
	}

}
