package com.restservices.utils;

public class RecordAlreadyExistsException extends Exception {
private String message;
	public RecordAlreadyExistsException(Integer sno) {
		this.message = "Record already exists with sno "+ sno;
	}
	
	public String getMessage() {
		return message;
	}
}
