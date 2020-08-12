package com.revature.models;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	public ArrayList<Customer> clients = new ArrayList<>();
	
	public User() {
		this.clients.add(new Customer());
		//this.clients.add(new Employee());
		//this.clients.add(new Admin());


	}

}
