package com.restservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restservices.models.People;
import com.restservices.services.PeopleService;
import com.restservices.utils.Message;
import com.restservices.utils.RecordAlreadyExistsException;

@RestController
@RequestMapping("/api")
public class PeopleAPI {

	@Autowired
	private PeopleService ps;
	
	@GetMapping("/people")
	public List<People> getPeople() {
		return ps.getPeople();
	}
	
	@PostMapping("/people")
	public ResponseEntity<Message> addPerson(@RequestBody People people) {
		try {
			ps.addPerson(people);
			return new ResponseEntity<Message>(new Message("Succesfuly Inserted"),HttpStatus.CREATED);
		}
		catch(RecordAlreadyExistsException e) {
			return new ResponseEntity<Message>(new Message("Record Already Exists"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Server side Error"),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
}
