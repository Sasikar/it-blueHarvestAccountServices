package com.blueharvest.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueharvest.dto.Customer;
import com.blueharvest.dto.DefaultAccount;



@Repository
public interface DefaultAccountDao extends JpaRepository<DefaultAccount, Long> {
	  public List<DefaultAccount> findByCustomerID(long customerID);
}
