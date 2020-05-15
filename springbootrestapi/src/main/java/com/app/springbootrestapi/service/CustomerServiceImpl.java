package com.app.springbootrestapi.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springbootrestapi.dao.CustomerDAO;
import com.app.springbootrestapi.entity.Customer;
import com.app.springbootrestapi.exception.CustomerNotFoundException;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public List<Customer> getAllCustomerList() {
		return customerDAO.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Optional<Customer> customer = customerDAO.findById(customerId);
		return customer.get();
	}

	@Override
	public Customer createOrUpdateCustomer(Customer cust) {
		System.out.println("Serice save customer" + cust.getCustomerId());
		if (cust.getCustomerId() != 0) {
			Optional<Customer> newCust = customerDAO.findById(cust.getCustomerId());

			System.out.println("find out customer is present or not :: "+newCust);
			if (newCust.isPresent()) {
				System.out.println("Customer present save it ");
				return customerDAO.save(cust);

			} else {
				
				Customer newCustomer =new Customer();
				newCustomer.setCustomerId(cust.getCustomerId());
				newCustomer.setCustomerName(cust.getCustomerName());
				newCustomer.setDateOfBirth(cust.getDateOfBirth());
				newCustomer.setGender(cust.getGender());
				System.out.println("add new Customer in db :: "+newCustomer.getCustomerId()+newCustomer.getCustomerName());
				
				return customerDAO.save(newCustomer);
			}
		} else {
			throw new CustomerNotFoundException("Customer Not Found : " + cust.getCustomerId());
		}

	}

	@Override
	public void deleteCustomer(int customerId) {
		Optional<Customer> customer = customerDAO.findById(customerId);
		customerDAO.deleteById(customerId) ;
		throw new CustomerNotFoundException("Customer Not Found : ");
	}

}
