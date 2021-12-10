package com.casestudy.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.Model.PaymentModel;


public interface PaymentRepository extends MongoRepository<PaymentModel, Integer> {




}
