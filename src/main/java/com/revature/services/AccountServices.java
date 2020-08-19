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
		input.nextLine();
		us.setAddress(input.nextLine());
		System.out.println("City: ");
		us.setCity(input.next());
		input.nextLine();
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
		
		int uid = user.addUser(us);
		int aid = acc.addAccount(a);
		
		ua.addAccountToUser(uid, aid);

		a.setStatus(false);
		a.setAccount_balance(0);	
		
		System.out.println("Your account is in review.");
		
		ConsoleUtility.Menus();
	}
	
	public float Deposit(Account a, float input) {
		System.out.println(a);
		if(input < 0 ) {
			System.out.println("You have entered a negative input please select a positive number!");
		}else {
			System.out.println("Deposit Amount: " + input);
			a.setAccount_balance(a.getAccount_balance() + input);
			System.out.println(a.getAccount_balance());
		
		acc.updateAccount(a);
		}
		return a.getAccount_balance();
		
	}
	public float Withdrawl(Account a, float input) {
		System.out.println("Withdrawl Amount: " + input);
		if(a.getAccount_balance() - input < 0) {
			System.out.println("You do not have sufficient toilet paper to withdrawl.");
			return 0;
		}else if(input < 0){
			System.out.println("You have entered a negative input please select a positive number!");
		}else {
			a.setAccount_balance(a.getAccount_balance() - input);
			System.out.println(a.getAccount_balance());
			System.out.println("Thank you your account will be updated accordingly.");		
		}
		acc.updateAccount(a);
		return a.getAccount_balance();
	}

	public void Transfer(Account a, Account b, float input) {
		System.out.println("Transfer Amount: " + input);
		float abalance = a.getAccount_balance();
		float balance = Withdrawl(a, input);
		if(balance == 0 && abalance != input) {
			return;
		}else {
			Deposit(b, input);
			return;
		}
		
	}
	
	// Still need to take care of Loggers
	
	


}
