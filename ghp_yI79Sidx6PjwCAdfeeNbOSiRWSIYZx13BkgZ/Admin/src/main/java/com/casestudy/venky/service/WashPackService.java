package com.casestudy.venky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casestudy.venky.models.WashPack;
import com.casestudy.venky.repository.WashPackRepository;

public class WashPackService {
	@Autowired
	WashPackRepository repo;
	
	public String savepack(WashPack pack) {
		
		
		repo.save(pack);
		return " Pack saved successfully with id :"+pack.getId();
	}

	
	public List<WashPack> getpack() {
		
		return repo.findAll();
	}

	
	public String deletepack(int id) {
		
		
		repo.deleteById(id);
		return "pack deleted with id "+id;
	}

}
