package com.revature.models;

import java.util.Scanner;

public class Account {
	
	private double currentBalance;
	private double endingBalance;
	private String accountType;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private int ssn;
	private String email;
	private String address;
	private String city;
	private String zip;
	private String state;
	private String applicationType;

	
	// Method to prompt user for input for new account creation calling the setter and passing in my Scanner.

	public void accountCreation(Scanner input) {
		System.out.println("Please Enter The Information Listed Below: ");
		System.out.println("First Name: ");
		this.setFirstName(input.next());
		System.out.println("Last Name: ");
		this.setLastName(input.next());
		System.out.println("Username: ");
		this.setUserName(input.next());
		System.out.println("Password: ");
		this.setPassword(input.next());
		System.out.println("SSN: ");
		this.setSsn(input.nextInt());
		System.out.println("E-mail Address: ");
		this.setEmail(input.next());
		System.out.println("Address: ");
		this.setAddress(input.next());
		System.out.println("City: ");
		this.setCity(input.next());
		System.out.println("State: ");
		this.setState(input.next());
		System.out.println("Zip: ");
		this.setZip(input.next());
		System.out.println("Please select your application type"  + "\n" + " [1] Customer Account" + "\n" +
		" [2] Employee Account " + "\n" + " [3] Admin Account ");
		switch(input.nextInt()){
			case 1: this.setAccountType("Customer");
			break;
			case 2: this.setAccountType("Employee");
			break;
			case 3: this.setAccountType("Admin");
			break;
			default: this.setAccountType("Customer");
			break;
			
		}
		
		
		
		
	}
	// Getters and setters
		public String getUserName() {
			return userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
			
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public double getSsn() {
			return ssn;
		}

		public void setSsn(int ssn) {
			this.ssn = ssn;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
		
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	
	public double getEndingBalance() {
		return endingBalance;
	}

	public String getAccountType() {
		return accountType;
	}
	
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public void setEndingBalance(double endingBalance) {
		this.endingBalance = endingBalance;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	
	


	
	

}
