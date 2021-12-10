package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Washer;

public interface WasherRepository extends MongoRepository<Washer, Integer> {

}
