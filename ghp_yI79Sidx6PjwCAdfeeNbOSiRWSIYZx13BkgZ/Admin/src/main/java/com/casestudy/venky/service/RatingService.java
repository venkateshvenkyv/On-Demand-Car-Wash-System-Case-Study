package com.casestudy.venky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casestudy.venky.models.Ratings;
import com.casestudy.venky.repository.RatingRepository;

public class RatingService {
	@Autowired
	RatingRepository repo;
	
	public String saverating(Ratings rating) {
		repo.save(rating);
		return " Thanks for Your Valuable feedback";
	
	}

	
	public List<Ratings> getuser() {
		
		return repo.findAll();
	}

	
}
