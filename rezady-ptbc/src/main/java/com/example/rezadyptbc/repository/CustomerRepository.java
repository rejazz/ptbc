package com.example.rezadyptbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rezadyptbc.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByName(String name);

}
