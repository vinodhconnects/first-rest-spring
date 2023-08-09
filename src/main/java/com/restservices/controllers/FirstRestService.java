package com.restservices.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirstRestService {

	@RequestMapping("/greet")
	public String greet() {
		 return " Spring boot is running";
	}
	
	@RequestMapping("/greet/{name}") //Path variables or positional Paramater
	public String greet(@PathVariable  String name) {
		 return "Hi!!! "+name;
	}
}
