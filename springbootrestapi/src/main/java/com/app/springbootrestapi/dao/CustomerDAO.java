/**
 * 
 */
package com.app.springbootrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springbootrestapi.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}
