package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;
import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao {
	Map<String, Account> accountEntry = new HashMap<>();
	Account account = new Account();

	public AccountDaoImpl() {
		accountEntry.put("9494709021", new Account("prepaid", "vaishali", 200));
		accountEntry.put("9502868840", new Account("prepaid", "Magha", 453));
		accountEntry.put("9441042395", new Account("prepaid", "vikas", 631));
		accountEntry.put("9492766237", new Account("prepaid", "Anju ", 521));

	}

	@Override
	public Account getAccountDetails(String mobileNo) {
		int count = 0;
		for (Map.Entry<String, Account> me : accountEntry.entrySet()) {

			if (mobileNo.equals(me.getKey())) {
				account = me.getValue();
				// System.out.println(me.getValue());//com.cg.mra.beans.Account@67b64c45

				count++;
			}

		}

		if (count == 0) {
			return null;
		} else {
			return account;
		}

	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		int bal = 0;
		int count = 0;
		
		for (Map.Entry<String, Account> me : accountEntry.entrySet()) {

			
			if (mobileNo.equals(me.getKey())) {
				account = (Account) me.getValue();
				//System.out.println(me.getValue());// com.cg.mra.beans.Account@6cd8737
				//System.out.println(account);// com.cg.mra.beans.Account@6cd8737
				bal = (int) (account.getAccountBalance() + rechargeAmount);
				account.setAccountBalance(bal);
				accountEntry.replace(mobileNo, account);
				count++;

			}
		}
		if (count == 0) {
			return 0;
		} else {
			return bal;
		}

	}

}
