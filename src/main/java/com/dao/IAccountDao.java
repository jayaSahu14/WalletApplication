package com.dao;

import com.model.Account;
import com.model.Customer;

public interface IAccountDao {
	
	public Account addAccount(Customer c, Account a);

}
