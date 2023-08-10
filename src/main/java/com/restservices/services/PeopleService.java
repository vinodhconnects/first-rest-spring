package com.restservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restservices.models.People;
import com.restservices.repositories.PeopleRepository;

import jakarta.annotation.PostConstruct;

@Service
public class PeopleService {

	@Autowired 
	PeopleRepository repo;//the implementation of this interface is taken care by data jpa
	
	@PostConstruct
	public void show() {
		System.out.println("Class name of repo"+repo.getClass());
		
	} //just for understanding
	
	public List<People> getPeople(){
		return repo.findAll();
	}
}
