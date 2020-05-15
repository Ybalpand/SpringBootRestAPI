package com.app.springbootrestapi.service;

import java.util.List;

import com.app.springbootrestapi.entity.Customer;

public interface CustomerService {

	List<Customer> getAllCustomerList();
	
	Customer getCustomerById(int customerId);
	
	Customer createOrUpdateCustomer(Customer customer);
	
	void deleteCustomer(int customerId);	
	
	
	
}
