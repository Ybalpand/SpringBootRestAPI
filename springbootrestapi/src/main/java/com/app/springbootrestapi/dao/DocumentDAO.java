package com.app.springbootrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springbootrestapi.entity.Document;

@Repository
public interface DocumentDAO extends JpaRepository<Document, Integer>{
	
}

