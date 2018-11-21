package com.blueharvest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blueharvest.dto.Customer;
import com.blueharvest.dto.DefaultAccount;
import com.blueharvest.dto.DefaultAccountTransaction;
import com.blueharvest.model.AccountRequest;
import com.blueharvest.model.AccountResponse;
import com.blueharvest.model.ErrorResponse;
import com.blueharvest.model.Transaction;
import com.blueharvest.model.UserInfo;
import com.blueharvest.service.CustomerDao;
import com.blueharvest.service.DefaultAccountDao;
import com.blueharvest.service.DefaultAccountTransactionDao;
import com.blueharvest.util.RestClientUtil;
import com.blueharvest.util.ValidationUtil;
import com.netflix.niws.client.http.RestClient;

@RestController

@RequestMapping("/")
public class AccountController {


	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private DefaultAccountDao defaultAccountDao;
	
	@Autowired
	private DefaultAccountTransactionDao defaultAccountTransactionDao;

	@RequestMapping(value = "/create/currentaccount", method = RequestMethod.POST)
	public Object createCurrentAccount(@RequestBody AccountRequest accountRequest) throws Exception {

		System.out.println("=======Entered Into createCurrentAccount Method======= ");

		System.out.println("came here");
		ServiceInstance serviceInstance = loadBalancer.choose("IT-HARVEST-TRANSACTIONSERVICE");
		String baseUrl = serviceInstance.getUri().toString();	
		System.out.println(baseUrl);
		
		List<Customer> customersList = customerDao.findAll();
		if (!ValidationUtil.customerExists(customersList,accountRequest)) {
			System.out.println("==================came==================");
			throw new ErrorResponse("Customer NOT Exists, this API is only intented to create current account ONLY for existing customers in system, to check Existing customers please see in this project path==> it-blueHarvestAccountServices\\src\\main\\resources\\data.sql Or Open http://localhost:7777/h2-console and provide JDBC URL as ==>jdbc:h2:mem:testdb userName as ==>sa Password as ==>sa click on connect button and Customer Table and type this SELECT * FROM TRANSACTION and click RUN");
			
		
		}

		// Create currenr accout Rest call

		if (!RestClientUtil.restServiceToCheckCurrentAccountExistsForCustomer(accountRequest,baseUrl)) {
			System.out.println("Creating Current Account");
			Transaction transaction = RestClientUtil
					.restServiceForCurrentAccountCreation(accountRequest,baseUrl);

			AccountResponse accountResponse = new AccountResponse();
			accountResponse.setCurrentAccountID(transaction.getCurrentAccount());
			accountResponse.setTransactionAmount(transaction.getInitialCredit());
			accountResponse.setCustomerID(accountRequest.getCustomerId());
			System.out.println("========Exists from createCurrentAccount Method =======");
			return accountResponse;

		} else {
			System.out.println("Customer already has current account");
			throw new ErrorResponse("Current Account for "+accountRequest.getCustomerId()+", Already created!!! You cannot create more than 1 current account for user, you can try to create current account for other existing customer.");
		}

	}
	
	@RequestMapping(value = "/userinfo/{customerId}", method = RequestMethod.GET)
	public UserInfo createCurrentAccount(@PathVariable long customerId) throws AccountException, ErrorResponse {
		
		ServiceInstance serviceInstance = loadBalancer.choose("IT-HARVEST-TRANSACTIONSERVICE");
		String baseUrl = serviceInstance.getUri().toString();	
		System.out.println(baseUrl);
		
		AccountRequest accountRequest = new AccountRequest();
		accountRequest.setCustomerId(customerId);
		List<Customer> customersList = customerDao.findAll();
		if (!ValidationUtil.customerExists(customersList,accountRequest)) {
			System.out.println("==================came==================");
			throw new ErrorResponse("Customer NOT Exists, this API is only intented to create current account ONLY for existing customers in system, to check Existing customers please see in this project path==> it-blueHarvestAccountServices\\src\\main\\resources\\data.sql Or Open http://localhost:7777/h2-console and provide JDBC URL as ==>jdbc:h2:mem:testdb userName as ==>sa Password as ==>sa click on connect button and Customer Table and type this SELECT * FROM TRANSACTION and click RUN");
		
		}
		List<Customer> customerList =customerDao.findByCustomerID(customerId);
		List<DefaultAccount> defaultAccountList = defaultAccountDao.findByCustomerID(customerId);
		List<DefaultAccountTransaction> defaultTransaction = defaultAccountTransactionDao.findByCustomerID(customerId);
		List<Transaction> currentAccountTransactions=RestClientUtil.restServiceToGetCurrentAccountDetails(accountRequest,baseUrl);
		return ValidationUtil.getUserInfo(customerList,defaultAccountList,defaultTransaction,currentAccountTransactions);
	}
}
