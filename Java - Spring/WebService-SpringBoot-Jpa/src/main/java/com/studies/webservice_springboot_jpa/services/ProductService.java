package com.studies.webservice_springboot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.webservice_springboot_jpa.entities.Product;
import com.studies.webservice_springboot_jpa.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id){
		Optional<Product> product =  productRepository.findById(id);
		return product.get();
	}
}
