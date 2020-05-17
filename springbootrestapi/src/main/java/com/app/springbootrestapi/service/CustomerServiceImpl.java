package com.app.springbootrestapi.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springbootrestapi.dao.CustomerDAO;
import com.app.springbootrestapi.dao.DocumentDAO;
import com.app.springbootrestapi.entity.Customer;
import com.app.springbootrestapi.entity.Document;
import com.app.springbootrestapi.exception.CustomerNotFoundException;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	DocumentDAO documentDAO ;
	
	@Override
	public List<Document> getAllDocumentList() {
		System.out.println("Document list In service layer");
		return documentDAO.findAll();
	}

	@Override
	public List<Customer> getAllCustomerList() {
		System.out.println("Customer List in service Layer");
		
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
				customerDAO.save(cust);
				documentDAO.saveAll(cust.getDocument());
				return cust;

			} else {
				
				Customer newCustomer =new Customer();
				newCustomer.setCustomerId(cust.getCustomerId());
				newCustomer.setCustomerName(cust.getCustomerName());
				newCustomer.setDateOfBirth(cust.getDateOfBirth());
				newCustomer.setGender(cust.getGender());
				System.out.println("add new Customer in db :: "+newCustomer.getCustomerId()+newCustomer.getCustomerName());
			
				List<Document> docList = cust.getDocument();
				for (Document doc : docList) {
					Document newDocument =new Document();
					newDocument.setDocumentId(doc.getDocumentId());
					newDocument.setDocumentName(doc.getDocumentName());
					newDocument.setDocumentExpiryDate(doc.getDocumentExpiryDate());
					newDocument.setDocumentAddress(doc.getDocumentAddress());
				
					newDocument.setCustomer(cust);
					
					documentDAO.save(newDocument);
					
					System.out.println("add new Document in db :: "+newDocument.getDocumentId());
				}
				
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
