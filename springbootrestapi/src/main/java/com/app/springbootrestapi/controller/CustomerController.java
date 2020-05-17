package com.app.springbootrestapi.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.springbootrestapi.entity.Customer;
import com.app.springbootrestapi.entity.Document;
import com.app.springbootrestapi.exception.CustomerNotFoundException;
import com.app.springbootrestapi.service.CustomerService;

@RequestMapping("/customers")
@RestController
public class CustomerController  {

	@Autowired
	private CustomerService customerService;
	
	
	// 1  get All Customer List
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> getAllCustomer(){
		System.out.println("Controller customer Layer ");
		  List<Customer> listcust= customerService.getAllCustomerList();
		  System.out.println("list of customer"+listcust);
		  for (Customer customer : listcust) {
			System.out.println(customer);
		}
		  return listcust;
	}
		
	@GetMapping("/documents")
	@ResponseStatus(HttpStatus.OK)
	public List<Document> getAllDocuments(){
		System.out.println("Controller Document Layer ");
		  List<Document> listOfDoc= customerService.getAllDocumentList();
		  System.out.println("list of Document"+listOfDoc);
		  for (Document doc : listOfDoc) {
			System.out.println(doc);
		}
		  return listOfDoc;
	}
	

	// 2  Get Customer by Id
	@GetMapping("/{customerId}")
		public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId) throws CustomerNotFoundException {
			Customer customer = customerService.getCustomerById(customerId);
			if (customerId <= 0) {
				System.out.println("400 (BAD REQUEST) : " + customerId);
				return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			}
			if (customer == null) {
				System.out.println("customer is null in case 404 no found /Customer id is not found : " + customerId);
				return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		
		// 3  create and update method
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<Customer> createOrUpdateCustomer(@Valid @RequestBody Customer customer) {
			System.out.println("Controller post method");
			Customer updated = customerService.createOrUpdateCustomer(customer);
			return new ResponseEntity<Customer>(updated, new HttpHeaders(), HttpStatus.OK);
		}

		// 4
		@DeleteMapping(value = "/{customerId}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public @ResponseBody void deleteCustomer(@PathVariable("customerId") int customerId) {
			System.out.println("Start deleteCustomer....");
			customerService.deleteCustomer(customerId);
		}

		

	
}
