package com.revature.utils;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.AccountDAO;
import com.revature.daos.UserAccountsDAO;
import com.revature.daos.UsersDAO;
import com.revature.models.Account;
import com.revature.models.Users;
import com.revature.services.AccountServices;
import com.revature.services.Login;



public class ConsoleUtility {
	
	private static UserAccountsDAO uacc = new UserAccountsDAO();
	private static AccountDAO acc = new AccountDAO();
	private static AccountServices  as = new AccountServices();
	private static UsersDAO us = new UsersDAO();
	private static final Scanner scan = new Scanner(System.in);

	
	public static void Menus() {
		System.out.println("Thank you for chooseing Bank of Toilet Paper");
		System.out.println("Would you like to: "
				+ "\n" + "[1] Login " + "\n" + "[2] Apply For New Account ");
		int userInput = scan.nextInt();
		switch(userInput) {
			case 1: Users user = Login.login();
				if(user!= null) {
					LoggedInMenu(user);
				}
			
			break;
			case 2:	AccountServices.accountCreation(scan);
			break;
			default: System.out.println("Please enter a valid option. (Numbers 1-2)");
			break;
		}
		
	}
	
	public static void LoggedInMenu(Users user){
		List<Account> accounts = uacc.findUserAccounts(user.getUser_id());
		System.out.println("Here are you accounts: ");
		for(int i = 0; i < accounts.size(); i++) {
			//will give me the option to select a number for which account to login to. 
			System.out.println("[" + (i+1) + "]"  + accounts.get(i).getAccount_type()); 

		}
		
		System.out.println("Which account would you like to access? ");
		int input = scan.nextInt();
		
		Account account = accounts.get(input - 1);
		
		if(account.getAccount_type() == "Checking" || account.getAccount_type() == "Savings") {
			System.out.println("Please select an option: "
					+ "\n" + "[1] Deposit " + "\n" + "[2] Withdrawl " + "\n" + "[3] Transfer to other Account" 
					+ "\n" + "[4] Logout");
			input = scan.nextInt();
			switch(input) {
			case 1:  System.out.println("How many rolls would you like to Deposit: ");
				float dinput= scan.nextFloat();
				as.Deposit(account, dinput);
				break;
			case 2:	System.out.println("How many rolls would you like to Withdrawl: ");
				float winput= scan.nextFloat();
				as.Deposit(account, winput);
				break;
			case 3: System.out.println("Which account are you transfering from: ");
					for(int i = 0; i < accounts.size(); i++) {
						//will give me the option to select a number for which account to login to. 
						
						// This is from account a checking or savings
						System.out.println("[" + (i+1) + "]"  + accounts.get(i).getAccount_type()); 
					}
					input = scan.nextInt();
					Account Acc = accounts.get(input - 1);
					
					// This is from account b checking or savings
					System.out.println("Which account are you transfering to: ");
					for(int i = 0; i < accounts.size(); i++) {
						System.out.println("[" + (i+1) + "]"  + accounts.get(i).getAccount_type()); 
					}
					input = scan.nextInt();
					Account Accb = accounts.get(input - 1);
					
					System.out.println("How many rolls would you like to transfer: ");
					float finput= scan.nextFloat();
					as.Transfer(Acc, Accb, finput);
				break;
			case 4: Menus(); 
				return;
			default: 
				break;
		}
			
			
		}
		
		else if(account.getAccount_type() == "Admin") {
			//Approve/Deny accounts
			//withdrawl, deposit, transfer from all accounts
			//close accounts. 
			System.out.println("What would you like to do?: " 
					+ "\n" + "[1] Approve / Deny account? " + "\n" + "[2] Deposit TP into account? " + "\n" + "[3] Withdrawl from account? "
					+ "\n" + "[4] Transfer TP to different account? " + "\n" + "[5] View All Accounts" + "\n" + "[6] Close a account?");
			input = scan.nextInt();
			switch(input) {
			case 1: 
			System.out.println("What would you like to do: " + "\n" + "[1] Approve" + "\n" + "[2] Deny");
			input = scan.nextInt();
			if(input == 1) {
				System.out.println("Please enter the account number of person you are approving: ");
				acc.openAccount(input);	
			}else if (input == 2) {
				System.out.println("Your account has been denied. Please try again at a different time. ");
			}else {
				System.out.println("Please enter a valid input.");
			}
			break;
			
		case 2:
			System.out.println("Which account would you like to Deposit TP into? ");
			acc.findById(input);
			if (account.getAccount_id() == input) {
				as.Deposit(account, input); // I may have used the wrong variable for account may need to change to a.
											// If this function doesn't work that may be why.
			}
			break;

		case 3:
			System.out.println("Which account would you like to Withdrawl TP from? ");
			acc.findById(input);
			if (account.getAccount_id() == input) {
				as.Withdrawl(account, input);
			}
			break;
			
		case 4:
			System.out.println("Which account are you transfering from: ");
			acc.findById(input);
			if (account.getAccount_type() == "Savings") {
				for (int i = 0; i < accounts.size(); i++) {
					// will give me the option to select a number for which account to login to.

					// This is from account a checking or savings
					System.out.println("[" + (i + 1) + "]" + accounts.get(i).getAccount_type());
				}
				input = scan.nextInt();
				Account Acc = accounts.get(input - 1);
			} else if (account.getAccount_type() == "Checking") {
				// This is from account b checking or savings
				for (int i = 0; i < accounts.size(); i++) {
					System.out.println("[" + (i + 1) + "]" + accounts.get(i).getAccount_type());
				}
				input = scan.nextInt();
				Account Accb = accounts.get(input - 1);
			} else {
				System.out.println("Please enter a valid account number. ");
			}
			break;
		case 5: // View all accounts
			break;
		case 6:
			System.out.println("Please enter account number of account being closed?");
			acc.closeAccount(input);
			if (account.getAccount_id() == input) {
				System.out.println("This account is now closed. We are sorry to see you go :(. We hope you don't run out of TP! ");
			}
			break;
		}
		}else { // Employee block
			//Approve/Deny open applications
			//Account Information
			//Account Balance
			//Personal Information
		}
		
		
		
	}



}
