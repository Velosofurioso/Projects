package com.studies.webservice_springboot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.webservice_springboot_jpa.entities.Order;
import com.studies.webservice_springboot_jpa.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	public List<Order> findAll(){
		return orderRepo.findAll();
	}
	
	public Order findById(Long id){
		Optional<Order> order =  orderRepo.findById(id);
		return order.get();
	}

}
