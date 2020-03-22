package com.capgemini.onlinewallet.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.onlinewallet.dto.Bank;
import com.capgemini.onlinewallet.dto.Transaction;
import com.capgemini.onlinewallet.dto.WalletAccount;


public class WalletAccountRepository
{
      private static Map<Integer, WalletAccount> listOfAccount=new HashMap<Integer, WalletAccount>();
   
      //Creating a constructor to add data into the repository. 
      public WalletAccountRepository()
      {
    	  Transaction transaction=new Transaction();
    	  new WalletUserRepository();
    	  List<Transaction> listOfTransaction=new ArrayList<Transaction>();
    	  
    	  WalletAccount account=new WalletAccount();
    	  account.setAccountBalance(1000);
    	  account.setAccountId(Bank.accountId++);
    	  account.setStatus("open");
    	  account.setWalletuser(WalletUserRepository.getWalletUserlist().get(0));
    	  
    	  transaction.setTransactionId(123);
    	  transaction.setAmount(500);
    	  transaction.setAccountBalance(account.getAccountBalance()+transaction.getAmount());
    	  account.setAccountBalance(transaction.getAccountBalance());
    	  listOfTransaction.add(transaction);
    	  
    	  transaction=new Transaction();
    	  transaction.setTransactionId(124);
    	  transaction.setAmount(-500);
    	  transaction.setAccountBalance(account.getAccountBalance()+transaction.getAmount());
    	  account.setAccountBalance(transaction.getAccountBalance());
    	  listOfTransaction.add(transaction);
    	  
    	  account.setTransactionHistory(listOfTransaction);
    	  listOfAccount.put(account.getAccountId(), account);
    	  
    	  
    	  listOfTransaction=new ArrayList<Transaction>();
    	  
    	  account=new WalletAccount();
    	  account.setAccountBalance(10000);
    	  account.setAccountId(Bank.accountId++);
    	  account.setStatus("open");
    	  account.setWalletuser(WalletUserRepository.getWalletUserlist().get(1));
    	  
    	  transaction=new Transaction();
    	  transaction.setTransactionId(133);
    	  transaction.setAmount(500);
    	  transaction.setAccountBalance(account.getAccountBalance()+transaction.getAmount());
    	  account.setAccountBalance(transaction.getAccountBalance());
    	  listOfTransaction.add(transaction);
    	  
    	  transaction=new Transaction();
    	  transaction.setTransactionId(134);
    	  transaction.setAmount(-500);
    	  transaction.setAccountBalance(account.getAccountBalance()+transaction.getAmount());
    	  account.setAccountBalance(transaction.getAccountBalance());
    	  listOfTransaction.add(transaction);
    	  
    	  account.setTransactionHistory(listOfTransaction);
    	  listOfAccount.put(account.getAccountId(), account);
      }

	public static Map<Integer, WalletAccount> getListOfAccount() {
		return listOfAccount;
	}

	public static void setListOfAccount(Map<Integer, WalletAccount> listOfAccount) {
		WalletAccountRepository.listOfAccount = listOfAccount;
	}
      
      
}





