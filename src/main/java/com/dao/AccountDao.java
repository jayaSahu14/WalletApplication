package com.dao;

import com.model.Account;
import com.model.Customer;

public class AccountDao implements IAccountDao {
	CustomerDao cd = new CustomerDao();
	@Override
	public Account addAccount(Customer c, Account a) {
		c.getAccount().add(a);
		return a;
	}

}
