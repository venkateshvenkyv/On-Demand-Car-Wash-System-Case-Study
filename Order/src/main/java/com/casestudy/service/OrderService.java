package com.casestudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.model.Order;
import com.casestudy.repository.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
    
	//for creating/adding order
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
     
	
	//for getting List of Order
	public List<Order> getOrders() {
		
		List<Order> order= orderRepository.findAll();
		System.out.println("Getting order from DB" + order);
		return order;
	}


	public void deleteById(int id) {
		orderRepository.deleteById(id);
		
	}

}
