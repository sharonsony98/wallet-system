package com.capgemini.onlinewallet.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.capgemini.onlinewallet.dao.AccountManagementDao;
import com.capgemini.onlinewallet.dto.Transaction;
import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.util.WalletAccountRepository;

public class AccountManagementDaoTest 
{

	
	AccountManagementDao daoObj;
	WalletUser userBean;
	WalletAccount accountBean;
	public AccountManagementDaoTest()
	{
		daoObj=new AccountManagementDao();
		accountBean =new WalletAccount();
		userBean=new WalletUser();
		userBean.setUserName("shubham");
		userBean.setPhoneNumber("1234567890");
		userBean.setUserId(123);
		List<Transaction> listOfTransaction=new ArrayList<Transaction>();
		Transaction transaction=new Transaction();
	  	  transaction.setTransactionId(133);
	  	  transaction.setAmount(500);
	  	  transaction.setAccountBalance(accountBean.getAccountBalance()+transaction.getAmount());
	  	  accountBean.setAccountBalance(transaction.getAccountBalance());
	  	  listOfTransaction.add(transaction);
	  	  
	  	  transaction=new Transaction();
	  	  transaction.setTransactionId(134);
	  	  transaction.setAmount(-500);
	  	  transaction.setAccountBalance(accountBean.getAccountBalance()+transaction.getAmount());
	  	  accountBean.setAccountBalance(transaction.getAccountBalance());
	  	  listOfTransaction.add(transaction);
	  	  
	  	  accountBean.setTransactionHistory(listOfTransaction);
		  	  
		accountBean.setAccountBalance(10000);
		accountBean.setStatus("open");
		accountBean.setWalletuser(userBean);
	}

	   @Test
	   public void addAccountTest()
	   {
			
			accountBean.setAccountId(null);
			assertTrue(daoObj.addAccount(accountBean));
			
			accountBean.setAccountId(1013);
			assertFalse(daoObj.addAccount(accountBean));
	   }
	   
	   @Test
	   public void updateAccountTest()
	   {
			accountBean.setAccountId(1001);
			assertTrue(daoObj.updateAccount(accountBean));
			
			accountBean.setAccountId(1000);
			assertFalse(daoObj.updateAccount(accountBean));
	   }
	   
	   @Test
	   public void showAccountTest()
	   {
			
			Map<Integer,WalletAccount> list=WalletAccountRepository.getListOfAccount();
			accountBean.setAccountId(1000);
			assertEquals(list.get(1000),daoObj.showAccount(accountBean));
			
			accountBean.setAccountId(1013);
			assertEquals(null,daoObj.showAccount(accountBean));
	   }
	   
	   @Test
	   public void showPassbookTest()
	   {
			
			Map<Integer,WalletAccount> list=WalletAccountRepository.getListOfAccount();

			accountBean.setAccountId(1000);
			assertEquals(list.get(1000),daoObj.showPassbook(accountBean));
			
			accountBean.setAccountId(1024);
			assertEquals(null,daoObj.showPassbook(accountBean));
			
	   }
		@Test
		public void deleteAccountTest()
		{
			
			accountBean.setAccountId(1001);
			assertTrue(daoObj.deleteAccount(accountBean));
			
			accountBean.setAccountId(1000);
			assertFalse(daoObj.deleteAccount(accountBean));
		}
}