package com.restservices.utils;

public class RecordNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private String message;
	public RecordNotFoundException(Integer sno) {
		this.message = "No Record found with sno "+ sno;
	}
	
	public String getMessage() {
		return message;
	}
}
