package com.model;
import java.time.LocalDate;

public class Account {
	private long accountNumber;
	private Customer customer;
	private AccountType accountType;
	private double openingBalance;
	private LocalDate openingDate;
	private String description;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(long accountNumber, Customer customer, AccountType accountType, double openingBalance,
			LocalDate openingDate, String description) {
		super();
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.accountType = accountType;
		this.openingBalance = openingBalance;
		this.openingDate = openingDate;
		this.description = description;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer=" + customer + ", accountType=" + accountType
				+ ", openingBalance=" + openingBalance + ", openingDate=" + openingDate + ", description=" + description
				+ "]";
	}
	
	
	
}
