package com.studies.webservice_springboot_jpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.studies.webservice_springboot_jpa.entities.Category;
import com.studies.webservice_springboot_jpa.entities.Order;
import com.studies.webservice_springboot_jpa.entities.Product;
import com.studies.webservice_springboot_jpa.entities.User;
import com.studies.webservice_springboot_jpa.entities.enums.OrderStatus;
import com.studies.webservice_springboot_jpa.repositories.CategoryRepository;
import com.studies.webservice_springboot_jpa.repositories.OrderRepository;
import com.studies.webservice_springboot_jpa.repositories.ProductRepository;
import com.studies.webservice_springboot_jpa.repositories.UserRepository;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;

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
		
		Category category1 = new Category(null, "Eletronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		
		categoryRepo.saveAll(Arrays.asList(category1, category2, category3));
		
		Product product1 = new Product(null, "The Lord of The Rings", "Lorem Ipsum Dolor Sit Ammet", 90.5, "");
		Product product2 = new Product(null, "Smart Tv", "null ammet dor estasium dollor", 2190.0, "");
		Product product3 = new Product(null, "MacBook Pro", "nam Elleford Situm Lorem Foraice", 1250.0, "");
		Product product4 = new Product(null, "PC Gamer", "Donec Aliquet naminus boreum lorec", 1200.00, "");
		Product product5= new Product(null, "Rails for Dummies", "Eras Frigilla jola magnum ommet zeru", 100.99, "");
		
		productRepo.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		// Atualiza os produtos adicionando as suas respectivas categotias
		product1.getCategories().add(category2);
		product2.getCategories().addAll(Arrays.asList(category1, category3));
		product3.getCategories().add(category3);
		product4.getCategories().add(category3);
		product5.getCategories().add(category2);
		
		productRepo.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
	}
}
