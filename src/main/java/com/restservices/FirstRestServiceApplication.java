package com.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.restservices.controllers")
public class FirstRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstRestServiceApplication.class, args);
	}

}
