package com.restservices.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class People {

	/**
	 * 
	 */

	
	@Id
	 private Integer sno;
	@Column
	 private String name;
	@Column
	 private String city;
	
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	public People(Integer sno, String name, String city) {
		super();
		this.sno = sno;
		this.name = name;
		this.city = city;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}
