package com.atmosware.testdemo.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.requests.CreatePaymentRequest;
import com.atmosware.testdemo.entities.concretes.Customer;
import com.atmosware.testdemo.entities.concretes.CustomerBalance;
import com.atmosware.testdemo.entities.concretes.Payment;

public class PaymentManager {
		
	CustomerManager customerManager ;	
	CustomerBalanceManager customerBalanceManager;
	public List<Payment> payments = new ArrayList<Payment>();
	
	public PaymentManager(CustomerManager customerManager,CustomerBalanceManager customerBalanceManager) {
		this.customerManager = customerManager;
		this.customerBalanceManager = customerBalanceManager;
		
	}
	
	public void add(CreatePaymentRequest createPaymentRequest) {
		
		customerManager.getById(createPaymentRequest.getCustomerId());
		CustomerBalance customerBalance  = customerBalanceManager.getById(createPaymentRequest.getCustomerId(), createPaymentRequest.getTotal());
		checkIfExpirationDate(createPaymentRequest.getCreateCreditCardRequest().getExpiration());
		
		Payment payment = new Payment();
		payment.setId(createPaymentRequest.getId());
		payment.setCustomerId(createPaymentRequest.getCustomerId());
		payment.setDate(LocalDate.now());
		payment.setTotal(createPaymentRequest.getTotal());
		payment.setTransactionId(customerBalance.getTransactionId());
		
		payments.add(payment);
				
		
	}
	
	
	public void checkIfExpirationDate(String expiration) {
		
		if(Integer.parseInt(expiration)>LocalDate.now().getMonthValue()) {
			throw new BusinessException("CreditCard expiry date error");
		}
	}
	
	

}
