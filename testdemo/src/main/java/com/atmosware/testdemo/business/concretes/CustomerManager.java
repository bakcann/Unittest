package com.atmosware.testdemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.entities.concretes.Customer;
import com.atmosware.testdemo.entities.concretes.CustomerBalance;

public class CustomerManager {
	
	public List<Customer> customers =new ArrayList<Customer>();
	
	public CustomerManager() {
		customers.add(new Customer(1,"Serhat","Ataş"));
		customers.add(new Customer(2,"Mehmet","Kandamar"));
		customers.add(new Customer(3,"Burak","Gültekin"));
	}
	
	public Customer getById(int customerId) {
		
		
		return getCustomer(customerId);
	}
	
	private Customer getCustomer(int customerId) {
		for (Customer customer : customers) {
			if(customer.getCustomerId()==customerId) {
				return customer;
			}
		}
		throw new BusinessException("Can not Customer");
	}
	
	

}
