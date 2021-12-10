package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer>{

}
