package com.capgemini.onlinewallet.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.exceptions.InvalidAccountDetailException;
import com.capgemini.onlinewallet.exceptions.InvalidUserDetailsException;
import com.capgemini.onlinewallet.service.AccountManagementService;

public class Client {

	
	public static void main(String[] args)
	{
		
		AccountManagementService  serviceObj=new  AccountManagementService();
		Scanner scanObject=new Scanner(System.in);
		
		WalletAccount accountBean;
		WalletUser userBean;
		
		int userChoice;
		while(true)
		{
			try 
			{
				System.out.println("Press\n1.show\n2.create\n3.Delete\n4.update\n5.ShowPassBook");
				userChoice=scanObject.nextInt();
				break;
			}
			catch(InputMismatchException exception)
			{
				System.out.println("Enter only numeric value");
				scanObject.next();
			}
		}
		
		while(userChoice!=0)
		{ 
			switch(userChoice)
			{
			case 1://showaccount
				accountBean =new WalletAccount();
				System.out.println("Enter account id");
				accountBean.setAccountId(scanObject.nextInt());
				try {
					accountBean=serviceObj.showAccount(accountBean);
				} catch (InvalidAccountDetailException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.println("account id : "+accountBean.getAccountId());
				System.out.println("user id : "+accountBean.getWalletuser().getUserId());
				System.out.println("user name : "+accountBean.getWalletuser().getUserName());
				System.out.println("phone number : "+accountBean.getWalletuser().getPhoneNumber());
				System.out.println("account balance : "+accountBean.getAccountBalance());
				break;
			case 2:
				//createaccount
				accountBean =new WalletAccount();
				userBean=new WalletUser();
				System.out.println("Enter user name");
				userBean.setUserName(scanObject.next());
				System.out.println("Enter contact");
				userBean.setPhoneNumber(scanObject.next());
				System.out.println("Enter user id");
				userBean.setUserId(scanObject.nextInt());
				System.out.println("Enter account balance"); 
				accountBean.setAccountBalance(scanObject.nextDouble());
				System.out.println("enter account status");
				accountBean.setStatus(scanObject.next());
				accountBean.setWalletuser(userBean);
				
				try {
					if(serviceObj.addAccount(accountBean)) 
					{
						System.out.println("account created : "+accountBean.getAccountId());
					}
					else
						System.out.println("Account not created : already exist");
				} catch (InvalidUserDetailsException e) {
					// TODO Auto-generated catch block
		  			System.out.println(e.getMessage());
				}
				break;
				 
			case 3:
			  //deleteaccount
				accountBean =new WalletAccount();
				System.out.println("Enter account id");
				accountBean.setAccountId(scanObject.nextInt());
				try {
					if(serviceObj.deleteAccount(accountBean))
					{
						System.out.println("Account deleted");
					}
					else
					{
						System.out.println("Account not deleted");
					}
				} catch (InvalidAccountDetailException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			
			case 4:
		       //updateaccount
				accountBean =new WalletAccount();
				System.out.println("Enter account id");
				accountBean.setAccountId(scanObject.nextInt());
				userBean=new WalletUser();
				System.out.println("Enter user name");
				userBean.setUserName(scanObject.next());
				System.out.println("Enter contact");
				userBean.setPhoneNumber(scanObject.next());
				try {
					if(serviceObj.updateAccount(accountBean))
						System.out.println("account updated");
					else
						System.out.println("Account not updated");
				} catch (InvalidUserDetailsException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				accountBean =new WalletAccount();
				System.out.println("Enter account id");
				accountBean.setAccountId(scanObject.nextInt());
				try {
					System.out.println(serviceObj.showPassbook(accountBean));
				} catch (InvalidAccountDetailException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Wrong input");
		}
			System.out.println("Press\n1.show\n2.create\n3.Delete\n4.update");
			userChoice=scanObject.nextInt();
		}
		scanObject.close();
	}
}	 