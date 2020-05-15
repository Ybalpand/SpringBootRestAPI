package com.app.springbootrestapi.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name="customer")

public class Customer {
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

	/*
	 * @Column(name="customer_document") private List<Document> document;
	 */

	public Customer() {
		super();
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



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + "]";
	}




	
	
}
