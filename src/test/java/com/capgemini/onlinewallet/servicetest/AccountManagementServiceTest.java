package com.capgemini.onlinewallet.servicetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.capgemini.onlinewallet.dto.Transaction;
import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.exceptions.InvalidAccountDetailException;
import com.capgemini.onlinewallet.exceptions.InvalidUserDetailsException;
import com.capgemini.onlinewallet.service.AccountManagementService;
import com.capgemini.onlinewallet.util.WalletAccountRepository;
 
public class AccountManagementServiceTest 
{
	AccountManagementService serviceObj;
	WalletUser userBean;
	WalletAccount accountBean;
	public AccountManagementServiceTest()
	{
		serviceObj=new AccountManagementService();
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
	public void deleteAccountTest() throws InvalidAccountDetailException
	{
		Throwable exception = assertThrows(
			      Exception.class,() -> {
			    	  accountBean.setAccountId(123);
			    	  serviceObj.deleteAccount(accountBean);
			      });
		assertEquals("invalid account id",exception.getMessage());
		
		accountBean.setAccountId(1000);
		assertTrue(serviceObj.deleteAccount(accountBean));
		
		accountBean.setAccountId(1013);
		assertFalse(serviceObj.deleteAccount(accountBean));
	}
	   @Test
	   public void addAccountTest() throws InvalidUserDetailsException
	   {
		   Throwable exception = assertThrows(
				      Exception.class,() -> {
				    	  userBean.setUserName("shubh123");
				    	  serviceObj.addAccount(accountBean);
				      });
			assertEquals("Invalid name",exception.getMessage());
			userBean.setUserName("shubham");
			
			exception = assertThrows(
				      Exception.class,() -> {
				    	  userBean.setPhoneNumber("123456789s");
				    	  serviceObj.addAccount(accountBean);
				      });
			assertEquals("Invalid phone number",exception.getMessage());
			userBean.setPhoneNumber("1234567890");
			
			exception = assertThrows(
				      Exception.class,() -> {
				    	  userBean.setPhoneNumber("1234567890123");
				    	  serviceObj.addAccount(accountBean);
				      });
			assertEquals("Invalid phone number",exception.getMessage());
			userBean.setPhoneNumber("1234567890");
			
			accountBean.setAccountId(null);
			assertTrue(serviceObj.addAccount(accountBean));
			
			accountBean.setAccountId(1013);
			assertFalse(serviceObj.addAccount(accountBean));
	   }
	   
	   @Test
	   public void updateAccountTest() throws InvalidUserDetailsException
	   {
		   Throwable exception = assertThrows(
				      Exception.class,() -> {
				    	  userBean.setUserName("shubh123");
				    	  serviceObj.updateAccount(accountBean);
				      });
			assertEquals("Invalid name",exception.getMessage());
			userBean.setUserName("shubham");
			
			exception = assertThrows(
				      Exception.class,() -> {
				    	  userBean.setPhoneNumber("123456789s");
				    	  serviceObj.updateAccount(accountBean);
				      });
			assertEquals("Invalid phone number",exception.getMessage());
			userBean.setPhoneNumber("1234567890");
			
			exception = assertThrows(
				      Exception.class,() -> {
				    	  userBean.setPhoneNumber("1234567890123");
				    	  serviceObj.updateAccount(accountBean);
				      });
			assertEquals("Invalid phone number",exception.getMessage());
			userBean.setPhoneNumber("1234567890");
			
			accountBean.setAccountId(1000);
			assertTrue(serviceObj.updateAccount(accountBean));
			
			accountBean.setAccountId(1013);
			assertFalse(serviceObj.updateAccount(accountBean));
	   }
	   
	   @Test
	   public void showAccountTest() throws InvalidAccountDetailException
	   {
		   Throwable exception = assertThrows(
				      Exception.class,() -> {
				    	  accountBean.setAccountId(123);
				    	  serviceObj.showAccount(accountBean);
				      });
			assertEquals("invalid account id",exception.getMessage());
			
			Map<Integer,WalletAccount> list=WalletAccountRepository.getListOfAccount();
			accountBean.setAccountId(1000);
			assertEquals(list.get(1000),serviceObj.showAccount(accountBean));
			
			accountBean.setAccountId(1013);
			assertEquals(null,serviceObj.showAccount(accountBean));
	   }
	   
	   @Test
	   public void showPassbookTest() throws InvalidAccountDetailException
	   {
		   Throwable exception = assertThrows(
				      Exception.class,() -> {
				    	  accountBean.setAccountId(123);
				    	  serviceObj.showPassbook(accountBean);
				      });
			assertEquals("invalid account id",exception.getMessage());
			
			Map<Integer,WalletAccount> list=WalletAccountRepository.getListOfAccount();

			accountBean.setAccountId(1000);
			assertEquals(list.get(1000),serviceObj.showPassbook(accountBean));
			
			accountBean.setAccountId(1013);
			assertEquals(null,serviceObj.showPassbook(accountBean));
			
	   }
}