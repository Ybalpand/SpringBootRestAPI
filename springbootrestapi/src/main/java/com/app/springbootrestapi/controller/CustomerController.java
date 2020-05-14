package com.app.springbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springbootrestapi.entity.Customer;
import com.app.springbootrestapi.service.CustomerService;

@RequestMapping("customer")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/all")
	public List<Customer> getAllCustomer(){
		System.out.println("Customer List ");
		  List<Customer> listcust= customerService.getAllCustomer();
		  for (Customer customer : listcust) {
			System.out.println("customer ID:: "+customer.getCustomerId() +"customer Name :  "+customer.getCustomerName());
		}
		  return listcust;
	}
	
	
}
