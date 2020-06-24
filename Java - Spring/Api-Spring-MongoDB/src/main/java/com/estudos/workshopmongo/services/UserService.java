package com.estudos.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.workshopmongo.domain.User;
import com.estudos.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repositorio;
	
	public List<User> findAll(){
		return repositorio.findAll();
	}
}
