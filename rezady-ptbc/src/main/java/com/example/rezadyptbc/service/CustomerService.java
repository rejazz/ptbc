package com.example.rezadyptbc.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rezadyptbc.entity.Customer;
import com.example.rezadyptbc.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}
	
	public List<Customer> saveCustomers(List<Customer> customers) {
		return repository.saveAll(customers);
	}
	
	public List<Customer> getCustomers() {
		return repository.findAll();
	}
	
	public Customer getCustomersByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteCustomer(int id) {
		repository.deleteById(id);
		return "Customer deleted"+id;
	}
	
	public String deleteCustomerByName(String name) {
		Customer cust = repository.findByName(name);
		repository.delete(cust);
		return "Customer deleted "+name;
	}
	
	public Customer updateCustomer(Customer customer) {
		Customer existingCustomer=repository.findByName(customer.getName());
		existingCustomer.setName(customer.getName());
		existingCustomer.setPhone(customer.getPhone());
		
		return repository.save(existingCustomer);
	}
}
