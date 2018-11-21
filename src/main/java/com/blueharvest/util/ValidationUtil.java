package com.blueharvest.util;

import java.util.ArrayList;
import java.util.List;

import com.blueharvest.dto.Customer;
import com.blueharvest.dto.DefaultAccount;
import com.blueharvest.dto.DefaultAccountTransaction;
import com.blueharvest.model.AccountRequest;
import com.blueharvest.model.AccountTransaction;
import com.blueharvest.model.Transaction;
import com.blueharvest.model.TransactionIds;
import com.blueharvest.model.Transactions;
import com.blueharvest.model.UserInfo;

public class ValidationUtil {

	public static boolean customerExists(List<Customer> customerList, AccountRequest accountRequest) {

		System.out.println("======Existing customers from InMemoryDB==" + customerList);
		System.out.println("======Requested customer====" + accountRequest.getCustomerId());

		List<Long> listCustomer = new ArrayList<Long>();
		for (Customer customer : customerList) {
			listCustomer.add(customer.getCustomerID());
		}
		if (listCustomer.contains(accountRequest.getCustomerId())) {
			System.out.println("======Requested Customer is existing Customer====" + accountRequest.getCustomerId());
			return true;
		} else {
			System.out.println("======Failed at Validation Requested Customer is NOT existing Customer===="
					+ accountRequest.getCustomerId());
			return false;
		}
	}

	public static UserInfo getUserInfo(List<Customer> customerList, List<DefaultAccount> defaultAccountList,
			List<DefaultAccountTransaction> defaultTransaction, List<Transaction> currentAccountTransactions) {
		UserInfo userInfo = new UserInfo();
		long balance=0;
		if (null != customerList) {
			userInfo.setCustomerId(customerList.get(0).getCustomerID());
			userInfo.setName(customerList.get(0).getFirstName() + " " + customerList.get(0).getLastName());
			userInfo.setSirName(customerList.get(0).getLastName());
		}
		Transactions transactions = new Transactions();
		List<AccountTransaction> accountTransactionList = new ArrayList<AccountTransaction>();
		List<TransactionIds> transactionIdForDefaultAccountList = new ArrayList<TransactionIds>();
		List<TransactionIds> transactionIdForCurrentAccountList = new ArrayList<TransactionIds>();

		AccountTransaction accountTransactionForDefaultAccount = new AccountTransaction();
		AccountTransaction accountTransactionForCurrentAccount = new AccountTransaction();
		TransactionIds TransactionIdsForDefaultAccount = new TransactionIds();
		TransactionIds TransactionIdsForCurrentAccount = new TransactionIds();

		accountTransactionForDefaultAccount.setAccountType("DefaultAccount");
		if (null != defaultTransaction) {
			TransactionIdsForDefaultAccount.setTransactionId(defaultTransaction.get(0).getTransactionID());
		}
		transactionIdForDefaultAccountList.add(TransactionIdsForDefaultAccount);
		accountTransactionForDefaultAccount.setTransactionIds(transactionIdForDefaultAccountList);

		accountTransactionForCurrentAccount.setAccountType("CurrentAccount");
		if (null != currentAccountTransactions) {
			TransactionIdsForCurrentAccount.setTransactionId(currentAccountTransactions.get(0).getTransactionID());
			balance+=currentAccountTransactions.get(0).getInitialCredit();
		}
		transactionIdForCurrentAccountList.add(TransactionIdsForCurrentAccount);
		accountTransactionForCurrentAccount.setTransactionIds(transactionIdForCurrentAccountList);

		accountTransactionList.add(accountTransactionForDefaultAccount);
		accountTransactionList.add(accountTransactionForCurrentAccount);

		transactions.setListAccounts(accountTransactionList);
		
		userInfo.setAccounts(transactions);
		
		
		if(null!=defaultAccountList) {
			balance+=defaultAccountList.get(0).getBalance();
		}
		userInfo.setBalance(balance);
		return userInfo;
		

	}
}
