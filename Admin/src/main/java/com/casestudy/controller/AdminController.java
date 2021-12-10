package com.casestudy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.models.Admin;
import com.casestudy.models.Order;
import com.casestudy.models.Ratings;
import com.casestudy.models.WashPack;
import com.casestudy.models.Washer;
import com.casestudy.repository.AdminRepository;
import com.casestudy.repository.RatingRepository;
import com.casestudy.repository.WashPackRepository;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private WashPackRepository washRepository;
	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private RestTemplate restTemplate;

//Adding Admin
	@PostMapping("/addadmin")
	public String saveAdmin(@RequestBody Admin admin) {
		adminRepository.save(admin);
		return "Admin Saved Successfully with id:" + admin.getaId();
	}

//Reading All admin
	@GetMapping("/alladmins")
	public List<Admin> getallAdmins() {
		return adminRepository.findAll();
	}
//Reading Admin by ID

	@GetMapping("/alladmins/{id}")
	public Optional<Admin> getadminbyId(@PathVariable int id) {
		return adminRepository.findById(id);
	}

	@PostMapping("/addpack")
	public String savepack(@RequestBody WashPack pack) {
		washRepository.save(pack);

		return "washpack Saved Successfully with id:" + pack.getId();

	}

	@GetMapping("/allpacks")
	public List<WashPack> getpack() {
		return washRepository.findAll();

		// return repo1.findAll();
	}

	@PostMapping("/addrating")
	public String saverating(@RequestBody Ratings rating) {
		
		ratingRepository.save(rating);
		 return " Thanks for Your Valuable feedback";
	}

	@GetMapping("/allratings")
	public List<Ratings> getuser() {
		
		return ratingRepository.findAll();
	}

	// Adding Washer
	@PostMapping("/addwasher")
	public String addWasher(@RequestBody Washer washer) {
	return restTemplate.postForObject("http://localhost:8003/washer/addwasher", washer, String.class);
	}
	
	
//Reading orders By
	@GetMapping("/getallorders/{id}")
	public Order getOrderById(@PathVariable("id") int id) {
		return restTemplate.getForObject("http://localhost:8082/order/orders/" + id, Order.class);
	}

//Reading All orders
	@GetMapping("/getallorders")
	public String getallOrder() {
		return restTemplate.getForObject("http://localhost:8082/order/allorders", String.class);
	}

}
