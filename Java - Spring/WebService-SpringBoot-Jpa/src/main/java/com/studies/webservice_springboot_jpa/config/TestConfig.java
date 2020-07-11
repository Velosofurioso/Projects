package com.studies.webservice_springboot_jpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.studies.webservice_springboot_jpa.entities.Order;
import com.studies.webservice_springboot_jpa.entities.User;
import com.studies.webservice_springboot_jpa.entities.enums.OrderStatus;
import com.studies.webservice_springboot_jpa.repositories.OrderRepository;
import com.studies.webservice_springboot_jpa.repositories.UserRepository;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Lucas", "lucas@gmail.com", "(11)9645-55265", "123456");
		User user3 = new User(null, "Maria", "maria@gmail.com", "(11)9789-57789", "147852");
		User user2 = new User(null, "João", "joao@gmail.com", "(11)94975-16324", "963852");
		
		userRepo.saveAll(Arrays.asList(user1,user2,user3));
		
		Order order1 = new Order(null, Instant.now(), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, user2);
		Order order3 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, user2);
		
		orderRepo.saveAll(Arrays.asList(order1, order2, order3));
		
	}


}
