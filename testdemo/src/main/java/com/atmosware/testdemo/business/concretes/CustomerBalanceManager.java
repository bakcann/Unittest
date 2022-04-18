package com.atmosware.testdemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.entities.concretes.Customer;
import com.atmosware.testdemo.entities.concretes.CustomerBalance;

public class CustomerBalanceManager {
	
	public List<CustomerBalance> customerBalances = new ArrayList<CustomerBalance>();
	
	public CustomerBalanceManager() {
		customerBalances.add(new CustomerBalance(1,1,200,8397));
		customerBalances.add(new CustomerBalance(2,2,250,8398));
		customerBalances.add(new CustomerBalance(3,3,150,8400));
	}
	
	public CustomerBalance getById(int customerId, double total) {
		
		CustomerBalance customerBalance = getCustomerBalance(customerId) ;
		checkIfBalance(customerBalance, total);
		return customerBalance;
	}
	
	private CustomerBalance getCustomerBalance(int customerId) {
		for (CustomerBalance customerBalance : customerBalances) {
			if(customerBalance.getCustomerId()== customerId) {
				return customerBalance;
			}
		}
		throw new BusinessException("Customerbalance not have ");
	}
	
	private void checkIfBalance(CustomerBalance customerBalance,double total) {
		if(customerBalance.getBalance()<total) {
			throw new BusinessException("Insufficient balance");
		}
	}

}
