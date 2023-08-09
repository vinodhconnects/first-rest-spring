package com.restservices.services;

import org.springframework.stereotype.Service;

@Service
public class DataService {
	
	String names[]= {"Joseph","Arjun","Naveen","Peterson","Mary"};
	
	public String[] getNames() {
		return names;
	}

}
