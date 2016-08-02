package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Customer;

public interface CustomerService {

	public void addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public List<Customer> listCustomers();
	public Customer getCustomerById(int id);
	public void removeCustomer(int id);
	
}
