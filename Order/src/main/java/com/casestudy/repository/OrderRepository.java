package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}
