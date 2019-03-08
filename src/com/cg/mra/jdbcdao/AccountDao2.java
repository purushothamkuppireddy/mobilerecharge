package com.cg.mra.jdbcdao;

import com.cg.mra.beans.Account;

public interface AccountDao2 {

	Account getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileno,double rechargeAmount);	

	
}
