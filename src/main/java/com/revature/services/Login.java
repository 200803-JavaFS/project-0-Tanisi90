package com.revature.services;

import java.util.Scanner;

import com.revature.daos.UsersDAO;
import com.revature.models.Users;

public class Login {
	
	Scanner s = new Scanner(System.in);
	
	public static void login() {
	System.out.println("Welcome to the bank of TP: ");
	System.out.println("Please Enter Your Username:");
	String username = s.nextLine();
	
	Users u = UsersDAO.getfindUser(username);
	

}
