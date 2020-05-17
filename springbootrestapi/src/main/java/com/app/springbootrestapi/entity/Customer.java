package com.app.springbootrestapi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="customer")

public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8772842572603198736L;
	
	
	@Id
	@Column(name="customer_id")
	//@GeneratedValue//(strategy=GenerationType.AUTO)
	private int customerId;
		
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_dob", nullable = false)
	@CreatedDate
	private Date dateOfBirth;

	@Column(name="customer_gender")
	private String gender;
		 
	
	@OneToMany( mappedBy = "customer", 
	cascade = CascadeType.ALL, 
	fetch = FetchType.EAGER) 
	private List<Document> document;   // = new ArrayList<Document>();
	

	public Customer() {
		super();
	}
	

	public Customer(List<Document> document, int customerId, String customerName, Date dateOfBirth, String gender) {
		super();
		this.document = document;
		this.customerId = customerId;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}



	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public List<Document> getDocument() {
		return document;
	}


	public void setDocument(List<Document> document) {
		this.document = document;
	}

	
	
}
