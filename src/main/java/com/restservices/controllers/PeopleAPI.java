package com.restservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restservices.models.People;
import com.restservices.services.PeopleService;

@RestController
@RequestMapping("/api")
public class PeopleAPI {

	@Autowired
	private PeopleService ps;
	
	@GetMapping("/people")
	public List<People> getPeople() {
		return ps.getPeople();
	}
}
