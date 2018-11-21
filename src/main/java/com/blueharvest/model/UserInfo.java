package com.blueharvest.model;

import java.util.List;

public class UserInfo {

	private long customerId;
	private String name;
	private String sirName;
	private Transactions accounts;
	private long balance;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSirName() {
		return sirName;
	}
	public void setSirName(String sirName) {
		this.sirName = sirName;
	}
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public Transactions getAccounts() {
		return accounts;
	}
	public void setAccounts(Transactions accounts) {
		this.accounts = accounts;
	}
	
	
	
	
}
