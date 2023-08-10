package com.restservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restservices.models.People;
import com.restservices.repositories.PeopleRepository;
import com.restservices.utils.RecordAlreadyExistsException;
import com.restservices.utils.RecordNotFoundException;

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
	
	public People getPeople(Integer sno) throws RecordNotFoundException {
		 People people=repo.findBySno(sno);
		 if(people!=null)
			 return people;
		 else 
			 throw new RecordNotFoundException(sno);
	}
	
	public void addPerson(People p) throws RecordAlreadyExistsException{
		try {
		 People people=repo.findBySno(p.getSno());
		 if(people!=null)
			 throw new RecordAlreadyExistsException(p.getSno());
		 else
		   repo.save(p);
		}
		catch(RecordAlreadyExistsException e) {
			throw e;
		}
	}
	
	public void updatePerson(People p) throws RecordNotFoundException{
		try {
		 People people=repo.findBySno(p.getSno());
		 if(people!=null) {
			 people.setName(p.getName()==null?people.getName():p.getName());
			 people.setCity(p.getCity()==null?people.getCity():p.getCity());
			 repo.save(people);
		 }
			
		 else
		     throw new RecordNotFoundException(p.getSno());
		}
		catch(RecordNotFoundException e) {
			throw e;
		}
	}
	
	
}
