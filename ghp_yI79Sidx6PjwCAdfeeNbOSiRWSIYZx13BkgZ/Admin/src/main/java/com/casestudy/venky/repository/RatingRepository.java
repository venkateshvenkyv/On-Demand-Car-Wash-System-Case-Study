package com.casestudy.venky.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.venky.models.Ratings;

public interface RatingRepository extends MongoRepository<Ratings, Integer> {

}
