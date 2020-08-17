package com.revature.utils;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.AccountDAO;
import com.revature.daos.UserAccountsDAO;
import com.revature.models.Account;
import com.revature.models.Users;
import com.revature.services.AccountServices;
import com.revature.services.Login;



public class ConsoleUtility {
	
	private static UserAccountsDAO uacc = new UserAccountsDAO();
	
	private static final Scanner scan = new Scanner(System.in);
	
	public static void Menus() {
		System.out.println("Thank you for chooseing Bank of TP");
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
					+ "\n" + "[1] Deposit " + "\n" + "[2] Withdrawl " + "\n" + "[3] Transfer to other Account");
			input = scan.nextInt();
		}
		
		else if(account.getAccount_type() == "Admin") {
			//Approve/Deny accounts
			//withdrawl, deposit, transfer from all accounts
			//close accounts. 
		}else {
			//Approve/Deny open applications
			//Account Information
			//Account Balance
			//Personal Information
		}
		
		
		
	}


}
