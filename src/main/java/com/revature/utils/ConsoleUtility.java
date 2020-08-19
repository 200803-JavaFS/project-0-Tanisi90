package com.revature.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.AccountDAO;
import com.revature.daos.UserAccountsDAO;
import com.revature.daos.UsersDAO;
import com.revature.daos.UsersIDAO;
import com.revature.models.Account;
import com.revature.models.Users;
import com.revature.services.AccountServices;





public class ConsoleUtility {
	
	private static UserAccountsDAO uacc = new UserAccountsDAO();
	private static AccountDAO acc = new AccountDAO();
	private static AccountServices  as = new AccountServices();
	private static UsersDAO us = new UsersDAO();
	private static final Scanner scan = new Scanner(System.in);
	private static final Logger log = LogManager.getLogger(ConsoleUtility.class);


	


	
	public static void Menus() {
		System.out.println("Thank you for chooseing Bank of Toilet Paper");
		System.out.println("Would you like to: "
				+ "\n" + "[1] Login " + "\n" + "[2] Apply For New Account ");
		int userInput = scan.nextInt();
		scan.nextLine();
		switch(userInput) {
			case 1: LoggedInMenu(login());
			break;
			case 2:	AccountServices.accountCreation(scan);
			break;
			default: System.out.println("Please enter a valid option. (Numbers 1-2)");
			break;
		}
		
	}

		public static Users login() {
			System.out.println("Please Enter Your Username");
			String username = scan.nextLine();
			us.findUsername(username);
			System.out.println("Please Enter Your Password");
			String password = scan.nextLine();
			us.findPassword(password);
		
			Users u = us.findUser(username, password);
			if(u != null) {
				System.out.println("Welcome " + u.getUsername());
				log.info(u.getUsername() + " Logged In:");
				return u;
			}else {
				log.info("Login Failed. Please try again!");
				return u;
			}
			
		}
	
	public static void LoggedInMenu(Users user){
		
		Account account = uacc.findUserAccounts(user.getUser_id() );
		System.out.println(account.getAccount_type());
		if(account.getAccount_type().equals("Customer")) {
		while(true) {
			System.out.println("Please select an option: "
					+ "\n" + "[1] Deposit " + "\n" + "[2] Withdrawl " + "\n" + "[3] Transfer to other Account" 
					+ "\n" + "[4] Logout");
			int input = scan.nextInt();
			
			
			switch(input) {
			case 1:  System.out.println("How many rolls would you like to Deposit: ");
				float dinput= scan.nextFloat();
				as.Deposit(account, dinput);
				break;
			case 2:	System.out.println("How many rolls would you like to Withdrawl: ");
				float winput= scan.nextFloat();
				as.Deposit(account, winput);
				break;
			case 3: 
					System.out.println("How much would you like to withdrawl? ");
					float awamount = scan.nextFloat();
					System.out.println("Which acount would you like to transfer to? ");
					input = scan.nextInt();
					Account ad = acc.findById(input);
					as.Transfer(account , ad , awamount );
				break;
			case 4: Menus(); 
				return;
			default: System.out.println("Closing Application");
				break;
		}
			}
		
		}else if(account.getAccount_type().equals("Admin")) {
			//Approve/Deny accounts
			//withdrawl, deposit, transfer from all accounts
			//close accounts. 
			while(true) {
			System.out.println("What would you like to do as the Admin?: " 
					+ "\n" + "[1] Approve / Deny account? " + "\n" + "[2] Deposit TP into account? " + "\n" + "[3] Withdrawl from account? "
					+ "\n" + "[4] Transfer TP to different account? " + "\n" + "[5] View All Accounts" + "\n" + "[6] Close a account?");
			int input = scan.nextInt();
			switch(input) {
			case 1: 
			System.out.println("What would you like to do: " + "\n" + "[1] Approve" + "\n" + "[2] Deny");
			input = scan.nextInt();
			if(input == 1) {
				System.out.println("Please enter the account number of person you are approving: ");
				input = scan.nextInt();
				if (acc.openAccount(input) ) {
					System.out.println("Yay! You have been Approved! ");
				}
			}else if (input == 2) {
				System.out.println("Please enter the account number of person you are denying: ");
				input = scan.nextInt();
				System.out.println("Your account has been denied. Please try again at a different time. ");
			}else {
				System.out.println("Please enter a valid input.");
			}
			break;
			
		case 2:
			System.out.println("Which account would you like to Deposit TP into? ");
			input = scan.nextInt();
			account = acc.findById(input);
			System.out.println("How much would you like to deposit? ");
			float amount = scan.nextFloat();
			as.Deposit(account, amount); 
			break;

		case 3:
			System.out.println("Which account would you like to Withdrawl TP from? ");
			input = scan.nextInt();
			account = acc.findById(input);
			System.out.println("How much would you like to withdrawl? ");
			float wamount = scan.nextFloat();
			as.Withdrawl(account, wamount);
			break;
			
		case 4:
			System.out.println("Which account are you transfering from: "); 
			int at = scan.nextInt();
			Account aw = acc.findById(at);
			System.out.println("How much would you like to withdrawl? ");
			float awamount = scan.nextFloat();
			System.out.println("Which acount would you like to transfer to? ");
			at = scan.nextInt();
			Account ad = acc.findById(at);
			as.Transfer(aw , ad , awamount );	
			break;
		case 5: 
			List<Account> fa = acc.findAll();
			for(int i = 0; i < fa.size(); i++ ) {
				System.out.println(fa.get(i));
			}
			break;
		case 6:
			System.out.println("Please enter account number of account being closed?");
			input = scan.nextInt();
			if (acc.closeAccount(input) ) {
				System.out.println("This account is now closed. We are sorry to see you go :(. "
						+ "We hope you don't run out of TP! ");
				Account a = acc.findById(input);
						a.setAccount_balance(0);
				acc.updateAccount(a);
				
			}
			break;
		default: System.out.println("Closing Application");
			}
		}
		}else { // Employee block
			//Approve/Deny open applications
			//Account Information
			//Account Balance
			//Personal Information
			while(true) {
			System.out.println("Have a beautiful day today! What would you like to accomplish today? :"
					+ "\n" + "[1] Look at unopened accounts " + "\n" + "[2] Get user account information"
					+ "\n" + "[3] View user account balance" + " \n" + "[4] Get users full information");
			int input = scan.nextInt();
			switch(input) {
			case 1: acc.findAllClosedAccounts();
			List<Account> faca = acc.findAllClosedAccounts();
			
			for(int i = 0; i < faca.size(); i++ ) {
				System.out.println(faca.get(i));
				acc.openAccount(faca.get(i).getAccount_id());
			}
			break;
			case 2: 
				input = scan.nextInt();
				System.out.println(acc.findById(input));
				break;
			case 3: 
				input = scan.nextInt();
				System.out.println(acc.accountBalance(input));
				break;
			case 4: 
				input = scan.nextInt();
				System.out.println(us.findById(input));
				break;
			default: System.out.println("Closing Application");
			
		}
			}
	}
	}
}




