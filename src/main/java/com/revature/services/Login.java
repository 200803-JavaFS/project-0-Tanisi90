package com.revature.services;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.UsersDAO;
import com.revature.daos.UsersIDAO;
import com.revature.models.Users;

public class Login {
	private static UsersIDAO userDao = new UsersDAO();
	private static final Logger log = LogManager.getLogger(Login.class);
	
	public static Scanner s = new Scanner(System.in);
	
	public static Users login() {
		System.out.println("Please Enter Your Username and Password:");
		String username = s.nextLine();
		String password = s.nextLine();
	
		Users u = userDao.findUser(username, password);
		if(u != null) {
			System.out.println("Welcome " + u.getUsername());
			log.info(u.getUsername() + " Logged In:");
			
			return u;
		}else {
			log.info("Login Failed. Please try again!");
			return u;
		}
		
	}
	

}
