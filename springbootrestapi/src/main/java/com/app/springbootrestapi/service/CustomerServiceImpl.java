package com.app.springbootrestapi.service;

import java.util.List;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springbootrestapi.dao.CustomerDAO;
import com.app.springbootrestapi.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO customerDAO;
	@Override
	public List<Customer> getAllCustomer() {
		System.out.println("Dao Layer");
		return customerDAO.findAll();
	}

}
