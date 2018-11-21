package com.blueharvest.model;

public class Transaction {

	private Long transactionID;

	private long custID;

	private long currentAccount;
	
	private long initialCredit;
	
	

	public long getInitialCredit() {
		return initialCredit;
	}

	public void setInitialCredit(long initialCredit) {
		this.initialCredit = initialCredit;
	}

	public Long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}

	public long getCustID() {
		return custID;
	}

	public void setCustID(long custID) {
		this.custID = custID;
	}

	public long getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(long currentAccount) {
		this.currentAccount = currentAccount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", custID=" + custID + ", currentAccount="
				+ currentAccount + "]";
	}

}
