package com.app.springbootrestapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="document")
public class Document implements Serializable {
	
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1318509914652066319L;

	@Id
	@Column(name="document_id")
	private int documentId;
	
	@Column(name="document_name")
	private String documentName;
	
	@Column(name="document_expiry_date", nullable = false)
	@CreatedDate
	private Date documentExpiryDate;
	
	@Column(name="document_address")
	private String documentAddress;
	
	/*
	 * @Column(name="customer_id") private int customerId;
	 */
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	@JsonIgnore
	private Customer customer;
	
	
	public Document() {
		super();
	}


	public Document(int documentId, String documentName, Date documentExpiryDate, String documentAddress,
			 Customer customer) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.documentExpiryDate = documentExpiryDate;
		this.documentAddress = documentAddress;
		//this.customerId = customerId;
		this.customer = customer;
	}


	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public Date getDocumentExpiryDate() {
		return documentExpiryDate;
	}

	public void setDocumentExpiryDate(Date documentExpiryDate) {
		this.documentExpiryDate = documentExpiryDate;
	}

	public String getDocumentAddress() {
		return documentAddress;
	}

	public void setDocumentAddress(String documentAddress) {
		this.documentAddress = documentAddress;
	}
	
	  public Customer getCustomer() { return customer; }
	  
	  public void setCustomer(Customer customer) { this.customer = customer; }
	 	
	
	  

		/*
		 * public int getCustomerId() { return customerId; }
		 */


		/*
		 * public void setCustomerId(int customerId) { this.customerId = customerId; }
		 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + documentId;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (documentId != other.documentId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", documentName=" + documentName + ", documentExpiryDate="
				+ documentExpiryDate + ", documentAddress=" + documentAddress + ", customer=" + customer + "]";
	}


}
