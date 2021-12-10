package com.casestudy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.exception.ApiRequestException;
import com.casestudy.model.Washer;
import com.casestudy.repository.WasherRepository;
import com.casestudy.service.WasherService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/washer")
public class WasherController {
	
	@Autowired
	private WasherService washerService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@Autowired
	private WasherRepository washerRepository;
	
	//Creating/Adding Washer
	@PostMapping("/addwasher")
	@ApiOperation("Adding the Washer")
	public Washer saveWasher(@RequestBody Washer washer) 
	{
		return washerService.addWasher(washer);
	}
	
	//Reading all washer
	@GetMapping("/allwashers")
	@ApiOperation("Adding the AllWasher")
	public List<Washer> findAllWashers(){
		return washerService.getWashers();
		
	}
	
	//Reading Washer by ID
	@GetMapping("/allwashers/{id}")
	@ApiOperation("Adding the All Washers with ID")
	public Optional<Washer> getWasherById(@PathVariable int id) throws ApiRequestException
	{
		return Optional.of(washerRepository.findById(id)
				.orElseThrow(()  -> new ApiRequestException("WASHER NOT FOUND WITH THIS ID ::") ) );
		
}
	//Updating Customer Data by Id
		@PutMapping("/update/{id}")
		@ApiOperation("Update the Washer")
		public ResponseEntity<Object> updateWasher(@PathVariable int id, @RequestBody Washer washer)
		{
			boolean isWasherExist=washerRepository.existsById(id);
			if(isWasherExist) {
				washerRepository.save(washer);
				return new ResponseEntity<Object>("Washer updated successfully with id " +id, HttpStatus.OK);
			}
			else 
			{
				throw new ApiRequestException("CAN NOT UPDATE AS WASHER NOT FOUND WITH THIS ID ::");
			}
			
		}
		
		// Deleting Customer Data by Id 
		@DeleteMapping("/delete/{id}")
		@ApiOperation("deleting the Washer")
		public ResponseEntity<Object> deleteCustomer (@PathVariable int id)
		{
			boolean isWasherExist=washerRepository.existsById(id);
			if(isWasherExist) {
				washerService.deleteById(id);
				return new ResponseEntity<Object>("Washer deleted with id"+id,HttpStatus.OK);
			}
			else
			{
				throw new ApiRequestException("CAN NOT DELETE AS WASHER NOT FOUND WITH THIS ID ::");
			}

		}
		
		// Reading All orders
		@GetMapping("/getallorders")
		@ApiOperation("Getting all the Orders")
		public String getAllOrder() {
		return restTemplate.getForObject("http://localhost:8082/order/allorders", String.class);



		}

		//Reading all the Ratings
		@GetMapping("/ratings")
		@ApiOperation("Getting all the Ratings")
		public String getAllRatings() {
		return restTemplate.getForObject("http://localhost:8000/Admin/allratings", String.class);
		}
		
		
}
