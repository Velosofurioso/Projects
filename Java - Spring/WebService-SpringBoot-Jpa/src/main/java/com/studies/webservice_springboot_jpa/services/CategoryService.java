package com.studies.webservice_springboot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.webservice_springboot_jpa.entities.Category;
import com.studies.webservice_springboot_jpa.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
	
	public Category findById(Long id){
		Optional<Category> category = categoryRepo.findById(id);
		return category.get();
	}
}
