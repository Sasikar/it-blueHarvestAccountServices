package com.blueharvest.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueharvest.dto.Customer;
import com.blueharvest.dto.DefaultAccount;
import com.blueharvest.dto.DefaultAccountTransaction;



@Repository
public interface DefaultAccountTransactionDao extends JpaRepository<DefaultAccountTransaction, Long> {
	  public List<DefaultAccountTransaction> findByCustomerID(long customer);
}
