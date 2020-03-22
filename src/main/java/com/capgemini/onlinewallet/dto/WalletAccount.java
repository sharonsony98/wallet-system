package com.capgemini.onlinewallet.dto;

import java.util.List;

public class WalletAccount
{
	//creating details variables
	private Integer accountId;
	private double accountBalance;
	private String status;
	List<Transaction> transactionHistory;
	private WalletUser walletuser;
	
	public WalletAccount() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public WalletUser getWalletuser() {
		return walletuser;
	}
	public void setWalletuser(WalletUser walletuser) {
		this.walletuser = walletuser;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Transaction> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(List<Transaction> listOfTransaction) {
		this.transactionHistory = listOfTransaction;
	}
 
	
}