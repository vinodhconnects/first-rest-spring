package com.restservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restservices.models.People;
import com.restservices.services.PeopleService;
import com.restservices.utils.Message;
import com.restservices.utils.RecordAlreadyExistsException;
import com.restservices.utils.RecordNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class PeopleAPI {

	@Autowired
	private PeopleService ps;
	
	 @Operation(
		      summary = "Read All People",
		      description = "Retrieve all People in the form of list")
		  @ApiResponses({
		      @ApiResponse(responseCode = "200", content = { @Content( mediaType = "application/json") }),
		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) 
		})
	 
	@GetMapping("/people")
	public List<People> getPeople() {
		return ps.getPeople();
	}
	
	 @Operation(
		      summary = "Retrieve a Person by Id",
		      description = "Get a Person object by specifying its id. The response is People object with sno,name and city")
		  @ApiResponses({
		      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = People.class), mediaType = "application/json") }),
		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) 
		})
		
	@GetMapping("/people/{sno}")//response may be either people object or message object
	public ResponseEntity getPeople(@PathVariable Integer sno) {
		try {
			return new ResponseEntity<People>(ps.getPeople(sno),HttpStatus.OK);
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity<Message>(new Message(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
	
	@RequestMapping(value="/people",method = {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<Message> updatePerson(@RequestBody People people) {
		try {
			ps.updatePerson(people);
			return new ResponseEntity<Message>(new Message("Succesfuly updated"),HttpStatus.OK);
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity<Message>(new Message(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Server side Error"),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@DeleteMapping(value="/people/{sno}")
	public ResponseEntity<Message> deletePerson(@PathVariable Integer sno) {
		try {
			ps.deletePerson(sno);
			return new ResponseEntity<Message>(new Message("Succesfuly deleted"),HttpStatus.OK);
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity<Message>(new Message(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Server side Error"),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
}
