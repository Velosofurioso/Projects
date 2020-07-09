package com.studies.webservice_springboot_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.webservice_springboot_jpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
