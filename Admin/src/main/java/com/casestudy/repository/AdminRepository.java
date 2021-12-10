package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.models.Admin;

public interface AdminRepository extends MongoRepository<Admin, Integer> {

}
