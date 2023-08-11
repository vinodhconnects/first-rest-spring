package com.restservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restservices.services.DataService;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestController
@RequestMapping("/api")
public class FirstRestService {
	@Autowired
	DataService ds;

	{
		System.out.println("First Rest Service up......");
		
	}

	@RequestMapping("/greet")
	public String greet() {
		 return " Spring boot is running";
	}
	
	@RequestMapping("/greet/{name}") //Path variables or positional Paramater
	public String greet(@PathVariable  String name) {
		 return "Hi!!! "+name;
	}
	
	@RequestMapping("/names")
	public String[] getNames() {
		return  ds.getNames();
	}
}
