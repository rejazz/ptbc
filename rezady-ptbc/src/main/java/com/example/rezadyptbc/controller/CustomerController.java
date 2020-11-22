package com.example.rezadyptbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rezadyptbc.entity.Customer;
import com.example.rezadyptbc.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	
	@PostMapping("/addCustomers")
	public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
		return service.saveCustomers(customers);
	}
	
	@GetMapping("/customers")
	public List<Customer> findAllCustomers() {
		return service.getCustomers();
	}
	
	@GetMapping("/customerById/{id}")
	public Customer findCustomerById(@PathVariable int id) {
		return service.getCustomersById(id);
	}
	
	@GetMapping("/customerByName/{name}")
	public Customer findCustomerByName(@PathVariable String name) {
		return service.getCustomersByName(name);
	}
	
	@PutMapping("/update")
	public Customer updateCustomers(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		return service.deleteCustomer(id);
	}
}
