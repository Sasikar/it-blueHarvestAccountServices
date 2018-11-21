package com.blueharvest.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

import com.blueharvest.model.AccountRequest;
import com.blueharvest.model.Transaction;

public class RestClientUtil {
	
	@Autowired
	private static LoadBalancerClient loadBalancer;

	

	public static Transaction restServiceForCurrentAccountCreation(AccountRequest accountRequest,String baseUrl) {
	
		final String uri = baseUrl+"/current/transaction/{customerId}/{initialcredit}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("customerId", String.valueOf(accountRequest.getCustomerId()));
		params.put("initialcredit", String.valueOf(accountRequest.getInitialCredit()));

		RestTemplate restTemplate = new RestTemplate();
		Transaction result = restTemplate.getForObject(uri, Transaction.class, params);

		System.out.println("============result=============" + result);
		return result;

	}

	public static boolean restServiceToCheckCurrentAccountExistsForCustomer(AccountRequest accountRequest,String baseUrl) throws Exception {
		final String uri = baseUrl+"/current/details/{customerId}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("customerId", String.valueOf(accountRequest.getCustomerId()));
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("came here too");
		Transaction[] result = restTemplate.getForObject(uri, Transaction[].class, params);
		System.out.println("==========restCall result======="+result);
		List<Transaction> transactionList = new ArrayList<>();
		CollectionUtils.addAll(transactionList, result);
		return currentAccountAlreadyCreatedForCustomer(transactionList, accountRequest.getCustomerId());

	}
	
	public static List<Transaction> restServiceToGetCurrentAccountDetails(AccountRequest accountRequest,String baseUrl) {
		final String uri = baseUrl+"/current/details/{customerId}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("customerId", String.valueOf(accountRequest.getCustomerId()));
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("came here too");
		Transaction[] result = restTemplate.getForObject(uri, Transaction[].class, params);
		System.out.println("==========restCall result======="+result);
		List<Transaction> transactionList = new ArrayList<>();
		CollectionUtils.addAll(transactionList, result);
		return transactionList;

	}

	public static boolean currentAccountAlreadyCreatedForCustomer(List<Transaction> transactionList,
			long requestedCustomer) {

		List<Long> customerList = new ArrayList<Long>();
		for (Transaction transaction : transactionList) {
			System.out.println("====each transaction in Transactions.."+transaction);
			customerList.add(transaction.getCustID());
		}

		if (customerList.contains(requestedCustomer)) {
			return true;
		} else {
			return false;
		}
	}
}
