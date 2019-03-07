package com.cg.mra.service;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.*;

public class AccountServiceImpl implements AccountService {
AccountDao ad=new AccountDaoImpl();
Account account=new Account();

public Account getAccountDetails(String mobileNo) {
	
	account=ad.getAccountDetails(mobileNo);
	return account;
}

public int rechargeAccount(String mobileno, double rechargeAmount) {
	
	int bal=ad.rechargeAccount( mobileno, rechargeAmount);
	return bal;
}

}
