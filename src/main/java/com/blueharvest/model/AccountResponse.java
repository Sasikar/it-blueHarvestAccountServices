package com.blueharvest.model;

public class AccountResponse {

	private String status="Success";
	private long currentAccountID;
	private long transactionAmount;
	private long customerID;
		
	
	
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public long getCurrentAccountID() {
		return currentAccountID;
	}
	public void setCurrentAccountID(long currentAccountID) {
		this.currentAccountID = currentAccountID;
	}
	public long getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AccountResponse [status=" + status + ", currentAccountID=" + currentAccountID + ", transactionAmount="
				+ transactionAmount + ", customerID=" + customerID + "]";
	}
	
	
	
	
}
