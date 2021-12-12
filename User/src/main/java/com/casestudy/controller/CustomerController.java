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
import com.casestudy.model.Customer;
import com.casestudy.model.Order;
import com.casestudy.model.PaymentModel;
import com.casestudy.model.Ratings;
import com.casestudy.repository.CustomerRepository;
import com.casestudy.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

	// Creating/ADDING Customer
	@PostMapping("/addcustomer")
	@ApiOperation("/Creating the add customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);

	}

	// Reading all Customer
	@GetMapping("/allcustomers")
	@ApiOperation("/Reading the all customer")
	public List<Customer> findAllCustomers() {
		return customerService.getCustomers();

	}

	// Reading Customer by ID
	@GetMapping("/allcustomers/{id}")
	@ApiOperation("/Reading the customer by ID")
	public Optional<Customer> getCustomerById(@PathVariable int id) throws ApiRequestException {
		return Optional.of(customerRepository.findById(id)
				.orElseThrow(() -> new ApiRequestException("CUSTOMER NOT FOUND WITH THIS ID ::")));
	}

	// Updating Customer Data by Id
	@PutMapping("/update/{id}")
	@ApiOperation("/Updating the customer by ID")
	public ResponseEntity<Object> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		boolean isCustomerExist = customerRepository.existsById(id);
		if (isCustomerExist) {
			customerRepository.save(customer);
			return new ResponseEntity<Object>("user updated successfully with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT UPDATE AS USER NOT FOUND WITH THIS ID ::");
		}

	}

	// Deleting Customer Data by Id
	@DeleteMapping("/delete/{id}")
	@ApiOperation("/Deleting the data by ID")
	public ResponseEntity<Object> deleteCustomer(@PathVariable int id) {
		boolean isCustomerExist = customerRepository.existsById(id);
		if (isCustomerExist) {
			customerService.deleteById(id);
			return new ResponseEntity<Object>("user deleted with id" + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		}

	}

	/*
	 * * Below code is for the Customer for the order * Customer can AddOrder and
	 * Delete Order
	 */

	// For Adding Order

	@PostMapping("/addorder") 
	public String addOrder (@RequestBody Order order) 
	{
	  return restTemplate.postForObject("http://localhost:8082/order/addorder", order , String.class);
	  
	  }

	

	// for Deleting Order

	@DeleteMapping("/cancelorder/{id}")
	@ApiOperation("/Cancel the order by ID")
	public String deleteorder(@PathVariable("id") int id) 
	{
		restTemplate.delete("http://localhost:8082/order/delete/" +id , String.class);
		return "Your Order is successfully Canceled " + id;
	}

/*	@PostMapping("/payment")
	@ApiOperation("for the payment")
	public String doPayment(@RequestBody PaymentPOJO payment) {
	return restTemplate.postForObject("http://localhost:8004/payment", payment,String.class);

	}   */
	
	
	//for adding Ratings
	@PostMapping("/addratings")
	@ApiOperation("/Getting all the Orders")
	public String addratings(@RequestBody Ratings ratings) 
	{
	  return restTemplate.postForObject("http://localhost:8000/Admin/addratings", ratings , String.class);
	  
	  }

	
	// Reading All orders
			@GetMapping("/getallorders")
			@ApiOperation("Getting all the Orders")
			public String getAllOrder() {
			return restTemplate.getForObject("http://localhost:8082/order/allorders", String.class);
			
			}

	//Reading all the Ratings
			@GetMapping("/ratings")
			@ApiOperation("/Getting all the Ratings")
			public String getAllRatings() {
			return restTemplate.getForObject("http://localhost:8000/Admin/allratings", String.class);
			}
			
	//Reading all the washpacks
			@GetMapping("/washpack")
			@ApiOperation("Getting all the washpacks")
			public String getAllWashpacks() {
			return restTemplate.getForObject("http://localhost:8000/Admin/allpacks", String.class);
			}

}
