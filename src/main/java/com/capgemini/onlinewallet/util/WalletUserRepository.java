package com.capgemini.onlinewallet.util;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.onlinewallet.dto.WalletUser;


public class WalletUserRepository
{ 
	////Creating a static List to store the DTO class object
	public static List<WalletUser> WalletUserlist=new ArrayList<WalletUser>();  
	
	
	//Creating a constructor to add data into the repository. 
	public WalletUserRepository()
	{  
		WalletUser walletUserObj=new WalletUser();
		walletUserObj.setUserId(1);
		walletUserObj.setUserName("sharon");
		walletUserObj.setPhoneNumber("1234567890");
		WalletUserlist.add(walletUserObj);
    
	walletUserObj=new WalletUser();
	walletUserObj.setUserId(2);
	walletUserObj.setUserName("aishwarya");
	walletUserObj.setPhoneNumber("0987654321");
	WalletUserlist.add(walletUserObj);
	}

	

	public static List<WalletUser> getWalletUserlist() {
		return WalletUserlist;
	}


	public static void setWalletUserlist(List<WalletUser> walletUserlist) {
		WalletUserlist = walletUserlist;
	}
	
}