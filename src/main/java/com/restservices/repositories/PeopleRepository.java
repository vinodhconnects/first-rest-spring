package com.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restservices.models.People;

public interface PeopleRepository  extends JpaRepository<People, Long>{
   public People findBySno(Integer sno); //this method will be implemented by data jpa
                                        //but convention must find +By+field name
}
