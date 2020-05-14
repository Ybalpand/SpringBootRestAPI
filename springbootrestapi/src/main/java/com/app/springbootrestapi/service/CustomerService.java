package com.app.springbootrestapi.service;

import java.util.List;

import com.app.springbootrestapi.entity.Customer;

public interface CustomerService {

	//Customer saveCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
}
