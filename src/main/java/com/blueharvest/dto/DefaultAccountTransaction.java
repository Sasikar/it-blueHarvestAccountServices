package com.blueharvest.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEFAULTACCOUNTTRANSACTION")
public class DefaultAccountTransaction {

	@Id
	private long customerID;
	private long transactionID;
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public long getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	
}
