package com.restservices.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirstRestService {

	@RequestMapping("/greet")
	public String greet() {
		 return " Spring boot is running";
	}
}
