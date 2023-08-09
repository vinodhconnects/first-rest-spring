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

/*

    Any class that is annotated with stereotype
(@Contoller/@RestController, @Service, @Component, @Repository) 
will be instatantiated automatically whenever the application 
is started

Whenever a request is made with a path, in each class the
request mapping are searched by dispatcherservlet and it would identify
appropriate method
*/