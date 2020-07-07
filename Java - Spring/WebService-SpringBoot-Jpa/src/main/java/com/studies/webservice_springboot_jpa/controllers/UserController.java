package com.studies.webservice_springboot_jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.webservice_springboot_jpa.entities.User;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@GetMapping
	public ResponseEntity<User> findaAll(){
		return ResponseEntity.ok().body(new User(Long.getLong("5"), "Lucas", "l.rbando815@gmail.com", "teste", "akaka"));
	}

}
