package com.capgemini.onlinewallet.dao;

import java.util.List;
import java.util.Map;

import com.capgemini.onlinewallet.dto.Bank;
import com.capgemini.onlinewallet.dto.Transaction;
import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.util.WalletAccountRepository;


public class AccountManagementDao
{
 
   public AccountManagementDao()
   {
	   new WalletAccountRepository();   
   }
   //deleteaccount
   public boolean deleteAccount(WalletAccount account)
   {
	   Map<Integer, WalletAccount> newAccountList=WalletAccountRepository.getListOfAccount();
	   if(newAccountList.containsKey(account.getAccountId()))
	   {
		   newAccountList.remove(account.getAccountId());
		   WalletAccountRepository.setListOfAccount(newAccountList);
		   return true;
	   }
	   return false;
   }
   //addaccount
   public boolean addAccount(WalletAccount account)
   {
	   Map<Integer, WalletAccount> newAccountList=WalletAccountRepository.getListOfAccount();
	   if(account.getAccountId()==null)
	   {
		   account.setAccountId(Bank.accountId++);
		   newAccountList.put(Bank.accountId, account);
		   WalletAccountRepository.setListOfAccount(newAccountList);
		   return true;
	   }
	   return false;
   }
    //updateaccount
   public boolean updateAccount(WalletAccount account)
   {
	   Map<Integer, WalletAccount> newAccountList=WalletAccountRepository.getListOfAccount();
	   if(newAccountList.containsKey(account.getAccountId()))
	   {
		   newAccountList.get(account.getAccountId()).getWalletuser().setPhoneNumber(account.getWalletuser().getPhoneNumber());
		   newAccountList.get(account.getAccountId()).getWalletuser().setUserName(account.getWalletuser().getUserName());
		   WalletAccountRepository.setListOfAccount(newAccountList);
		   return true;
	   }
	   return false;
   }
   //showaccount
   public WalletAccount showAccount(WalletAccount account)
   {
	   Map<Integer, WalletAccount> newAccountList=WalletAccountRepository.getListOfAccount();
	   if(newAccountList.containsKey(account.getAccountId()))
	   {
		   return newAccountList.get(account.getAccountId());
	   }
	   return null;
   }
   //showpassbook
   public List<Transaction> showPassbook(WalletAccount account)
   {
	   Map<Integer, WalletAccount> newAccountList=WalletAccountRepository.getListOfAccount();
	   if(newAccountList.containsKey(account.getAccountId()))
	   {
		   return newAccountList.get(account.getAccountId()).getTransactionHistory();
	   }
	   return null;
   }
}
