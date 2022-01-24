package com.casestudy.venky.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.venky.models.Admin;

public interface AdminRepository extends MongoRepository<Admin, Integer> {

	Admin findByUsername(String username);
}
