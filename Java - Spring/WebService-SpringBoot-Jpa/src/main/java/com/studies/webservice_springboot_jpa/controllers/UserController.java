package com.studies.webservice_springboot_jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.webservice_springboot_jpa.entities.User;
import com.studies.webservice_springboot_jpa.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> users = userService.findAll();
		
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findaAll(@PathVariable(required = true) String id){
		
		User users = userService.findById(Long.parseLong(id));
		
		return ResponseEntity.ok().body(users);
	}

}
