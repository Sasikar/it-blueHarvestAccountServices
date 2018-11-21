package com.blueharvest.model;

public class AccountRequest {

	private long customerId;
	private long initialCredit;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getInitialCredit() {
		return initialCredit;
	}
	public void setInitialCredit(long initialCredit) {
		this.initialCredit = initialCredit;
	}
	@Override
	public String toString() {
		return "AccountRequest [customerId=" + customerId + ", initialCredit=" + initialCredit + "]";
	}
	
	
}
