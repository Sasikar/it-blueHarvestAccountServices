package com.blueharvest.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueharvest.dto.Customer;



@Repository

public interface CustomerDao extends JpaRepository<Customer, Long> {
 
    public List<Customer> findAll();
 
    public List<Customer> findByCustomerID(long customer);
 
}