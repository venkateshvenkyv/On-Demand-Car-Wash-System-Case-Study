package com.casestudy.venky.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.venky.models.WashPack;

public interface WashPackRepository extends MongoRepository<WashPack, Integer> {

}
