package com.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restservices.models.People;

public interface PeopleRepository  extends JpaRepository<People, Long>{

}
