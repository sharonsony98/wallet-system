package com.capgemini.onlinewallet.service;
import com.capgemini.onlinewallet.dao.AccountManagementDao;
import com.capgemini.onlinewallet.dto.Transaction;
import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.exceptions.InvalidAccountDetailException;
import com.capgemini.onlinewallet.exceptions.InvalidUserDetailsException;

import java.util.List;
	
public class AccountManagementService
{
	
	
	AccountManagementDao daoObj;
	public AccountManagementService()
	{
		daoObj=new AccountManagementDao();
	}
	//deleteaccount
	public boolean deleteAccount(WalletAccount account) throws InvalidAccountDetailException
	{
		if(String.valueOf(account.getAccountId()).length()!=4)
			throw new InvalidAccountDetailException("invalid account id");
		
		   if(daoObj.deleteAccount(account))
		   {
			   return true;
		   }
		   return false;
	}
	    //addaccount
	   public boolean addAccount(WalletAccount account) throws InvalidUserDetailsException
	   {
		   if(!account.getWalletuser().getUserName().matches("^[a-zA-Z]*$"))
		   		throw new InvalidUserDetailsException("Invalid name");
		   if(!account.getWalletuser().getPhoneNumber().matches("[0-9]+") || account.getWalletuser().getPhoneNumber().length()!=10)
			    throw new InvalidUserDetailsException("Invalid phone number");
		   if(daoObj.addAccount(account))
		   {
			   return true;
		   }
		   return false;
	   }
	   //updateaccount
	   public boolean updateAccount(WalletAccount account) throws InvalidUserDetailsException
	   {
		   if(!account.getWalletuser().getUserName().matches("^[a-zA-Z]*$"))
		   		throw new InvalidUserDetailsException("Invalid name");
		   if(!account.getWalletuser().getPhoneNumber().matches("[0-9]+") || account.getWalletuser().getPhoneNumber().length()!=10)
			    throw new InvalidUserDetailsException("Invalid phone number");
		   if(daoObj.updateAccount(account))
		   {
			   return true;
		   }
		   return false;
	   }
	   //showaccount
	   public WalletAccount showAccount(WalletAccount account) throws InvalidAccountDetailException
	   {
		   if(String.valueOf(account.getAccountId()).length()!=4)
				throw new InvalidAccountDetailException("invalid account id");
		   return daoObj.showAccount(account);
	   }
	   //showpassbook
	   public List<Transaction> showPassbook(WalletAccount account) throws InvalidAccountDetailException
	   {
		   if(String.valueOf(account.getAccountId()).length()!=4)
				throw new InvalidAccountDetailException("invalid account id");
		   return daoObj.showPassbook(account);
	   }
	
}

	
