package com.blueharvest.model;

import java.util.List;

public class AccountTransaction {
	private String accountType;
	private List<TransactionIds> transactionIds;
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public List<TransactionIds> getTransactionIds() {
		return transactionIds;
	}
	public void setTransactionIds(List<TransactionIds> transactionIds) {
		this.transactionIds = transactionIds;
	}
	
	
}
