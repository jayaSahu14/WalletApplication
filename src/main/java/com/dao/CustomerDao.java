package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Customer;

public class CustomerDao implements ICustomerDao {
	public static List<Customer> customerList = new ArrayList<>();
	
	
	
	public CustomerDao() {
		Customer c = new Customer(5, "jaya", "sahu", "jaya", null, null, "123", null, null, new ArrayList<>());
		customerList.add(c);
	}

	@Override
	public Customer registerCustomer(Customer c) {
		customerList.add(c);
		return c;
	}

	@Override
	public boolean validateCustomer(String emailId, String password) {
		for(Customer c : customerList) {
			if(c.getEmailId().equals(emailId)) {
				if(c.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

}
