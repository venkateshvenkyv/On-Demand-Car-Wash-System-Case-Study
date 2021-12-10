package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.models.Ratings;

public interface RatingRepository extends MongoRepository<Ratings, Integer> {

}
