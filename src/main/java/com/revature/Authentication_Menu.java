package com.revature;
import com.revature.models.Account;
import java.util.Scanner;


public class Authentication_Menu  {
	
	
	// Constructs a Authentication Menu for my Banking Application
	public Authentication_Menu() {
		super();
	}
	
	public void Menus() {
		System.out.println("Thank you for chooseing Bank of TP");
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to: "
				+ "\n" + "[1] Login " + "\n" + "[2] Apply For New Account ");
		int userInput = input.nextInt();
		switch(userInput) {
			case 1:  System.out.println("Function goes here");
			break;
			//case 2:	Account accounts = new Account();
			//	accounts.createAccount(input);
			//break;
			default: System.out.println("Please enter a valid option. (Numbers 1-2)");
			break;
		}
		
	}

	
	
	
	
	
	

	
	

}
