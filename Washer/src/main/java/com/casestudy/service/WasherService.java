package com.casestudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.model.Washer;
import com.casestudy.repository.WasherRepository;


@Service
public class WasherService {
	
	@Autowired
	private WasherRepository washerRepository;
    
	//for creating/adding washer
	public Washer addWasher(Washer washer) {
		return washerRepository.save(washer);
	}
     
	
	//
	public List<Washer> getWashers() {
		// TODO Auto-generated method stub
		List<Washer> washer= washerRepository.findAll();
		System.out.println("Getting Washer from DB" + washer);
		return washer;
	}


	public void deleteById(int id) {
		washerRepository.deleteById(id);
		
	}

}
