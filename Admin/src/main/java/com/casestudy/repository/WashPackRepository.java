package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.models.WashPack;

public interface WashPackRepository extends MongoRepository<WashPack, Integer> {

}
