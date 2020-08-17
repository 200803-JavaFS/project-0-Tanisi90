package com.revature.services;

import java.util.Scanner;

import com.revature.daos.AccountDAO;
import com.revature.daos.UserAccountsDAO;
import com.revature.daos.UsersDAO;
import com.revature.models.Account;
import com.revature.models.Users;
import com.revature.utils.ConsoleUtility;

public class AccountServices {
	
	private static AccountDAO acc = new AccountDAO();
	private static UsersDAO user = new UsersDAO();
	private static UserAccountsDAO ua = new UserAccountsDAO();
	// Method to prompt user for input for new account creation calling the setter and passing in my Scanner.

	public static void accountCreation(Scanner input) {
		
		Users us = new Users();
		Account a = new Account();
		System.out.println("Please Enter The Information Listed Below: ");
		System.out.println("First Name: ");
		us.setFirst_name(input.next());
		System.out.println("Last Name: ");
		us.setLast_name(input.next());
		System.out.println("Username: ");
		us.setUsername(input.next());
		System.out.println("Password: ");
		us.setPassword(input.next());
		System.out.println("SSN: ");
		us.setSocial_number(input.next());
		System.out.println("E-mail Address: ");
		us.setEmail(input.next());
		System.out.println("Address: ");
		us.setAddress(input.next());
		System.out.println("City: ");
		us.setCity(input.next());
		System.out.println("State: ");
		us.setState(input.next());
		System.out.println("Zip: ");
		us.setZip(input.next());
		System.out.println("Please select your application type"  + "\n" + " [1] Customer Account" + "\n" +
		" [2] Employee Account " + "\n" + " [3] Admin Account ");
		switch(input.nextInt()){
			case 1: a.setAccount_type("Customer");
			break;
			case 2: a.setAccount_type("Employee");
			break;
			case 3: a.setAccount_type("Admin");
			break;
			default: a.setAccount_type("Please enter a valid response");
			break;
			
		}
		
		a.setStatus(false);
		a.setAccount_balance(0);
		
		int uid = user.addUser(us);
		int aid = acc.addAccount(a);
		
		ua.addAccountToUser(uid, aid);
		
		System.out.println("Your account is in review.");
		
		ConsoleUtility.Menus();
	}
	
	
	
	
	


}
