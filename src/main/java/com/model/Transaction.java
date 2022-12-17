package com.model;

public class Transaction {
	private int transcationId;
	private TransactionType transactionType;
	private double amount;
	private String description;
	private Account fromAccount;
	private Account toAccount;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Transaction(int transcationId, TransactionType transactionType, double amount, String description,
			Account fromAccount, Account toAccount) {
		super();
		this.transcationId = transcationId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.description = description;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}
	public int getTranscationId() {
		return transcationId;
	}
	public void setTranscationId(int transcationId) {
		this.transcationId = transcationId;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	@Override
	public String toString() {
		return "Transaction [transcationId=" + transcationId + ", transactionType=" + transactionType + ", amount="
				+ amount + ", description=" + description + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount
				+ "]";
	}
	
	

}
