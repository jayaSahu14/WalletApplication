package com.dao;

import com.model.Customer;

public interface ICustomerDao {
	public Customer registerCustomer(Customer c);
	public boolean validateCustomer(String emailId, String password);

}
