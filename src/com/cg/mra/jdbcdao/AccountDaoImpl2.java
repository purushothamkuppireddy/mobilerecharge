package com.cg.mra.jdbcdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.cg.mra.beans.Account;

public class AccountDaoImpl2 implements AccountDao2 {
	Account a = new Account();

	@Override
	public Account getAccountDetails(String mobileNo) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpr", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from mra where MobileNo=?");
			ps.setString(1, mobileNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Welcome " + rs.getString(3));
				a.setCustomerName(rs.getString(3));
				a.setAccountBalance(rs.getDouble(4));
				count = 1;
			} else {
				count = 0;
			}

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count == 1)
			return a;
		else
			return null;
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		int bal = 0;
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpr", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from mra where MobileNo=?");
			ps.setString(1, mobileNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PreparedStatement ps2 = con.prepareStatement("update mra set bal=? where MobileNo=?");
				ps2.setString(2, mobileNo);

				ps2.setDouble(1, (rs.getDouble(4) + rechargeAmount));
				bal = (int) (rs.getDouble(4) + rechargeAmount);
				ps2.executeUpdate();

				count = 1;
			} else {
				count = 0;
			}

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (count == 0) {
			return 0;
		} else {
			return bal;
		}

	}
}
