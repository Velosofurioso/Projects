package com.studies.webservice_springboot_jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.webservice_springboot_jpa.entities.Order;
import com.studies.webservice_springboot_jpa.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> orders = orderService.findAll();
		
		return ResponseEntity.ok().body(orders); 
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findAll(@PathVariable(required = true) Long id){
		
		Order orders = orderService.findById(id);
		
		return ResponseEntity.ok().body(orders); 
	}


}
