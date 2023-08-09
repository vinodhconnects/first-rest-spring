package com.restservices.services;

import org.springframework.stereotype.Service;

@Service
public class DataService {
	
	String names[]= {"Joseph","Arjun","Naveen","Peterson","Mary"};
	
	{
		System.out.println("Dataservice up......");
		
	}
	
	public String[] getNames() {
		return names;
	}

}
