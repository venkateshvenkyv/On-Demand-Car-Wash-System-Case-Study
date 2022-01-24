package com.casestudy.venky.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.venky.models.Washer;

public interface WasherRepository extends MongoRepository<Washer, Integer> {
	
	Washer findByUsername(String username);

}
