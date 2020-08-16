package com.revature.models;

import java.io.Serializable;
import java.util.Scanner;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	private int account_id;
	private String account_type;
	private float account_balance;
	private boolean status;


	public Account(String account_type, float account_balance, boolean status) {
		super();
		this.account_type = account_type;
		this.account_balance = account_balance;
		this.status = status;
	}
	
	public Account(int account_id, String account_type, float account_balance, boolean status) {
		super();
		this.account_id = account_id;
		this.account_type = account_type;
		this.account_balance = account_balance;
		this.status = status;
	}


	// Method to prompt user for input for new account creation calling the setter and passing in my Scanner.

//	public void accountCreation(Scanner input) {
//		System.out.println("Please Enter The Information Listed Below: ");
//		System.out.println("First Name: ");
//		this.setFirstName(input.next());
//		System.out.println("Last Name: ");
//		this.setLastName(input.next());
//		System.out.println("Username: ");
//		this.setUserName(input.next());
//		System.out.println("Password: ");
//		this.setPassword(input.next());
//		System.out.println("SSN: ");
//		this.setSsn(input.nextInt());
//		System.out.println("E-mail Address: ");
//		this.setEmail(input.next());
//		System.out.println("Address: ");
//		this.setAddress(input.next());
//		System.out.println("City: ");
//		this.setCity(input.next());
//		System.out.println("State: ");
//		this.setState(input.next());
//		System.out.println("Zip: ");
//		this.setZip(input.next());
//		System.out.println("Please select your application type"  + "\n" + " [1] Customer Account" + "\n" +
//		" [2] Employee Account " + "\n" + " [3] Admin Account ");
//		switch(input.nextInt()){
//			case 1: this.setAccount_type("Customer");
//			break;
//			case 2: this.setAccount_type("Employee");
//			break;
//			case 3: this.setAccount_type("Admin");
//			break;
//			default: this.setAccount_type("Please enter a valid response");
//			
//			break;
//			
//		}
//		
//	}



	// Getters and setters
	public int getAccount_id() {
		return account_id;
	}


	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}


	public String getAccount_type() {
		return account_type;
	}


	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}


	public float getAccount_balance() {
		return account_balance;
	}


	public void setAccount_balance(float account_balance) {
		this.account_balance = account_balance;
	}
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(account_balance);
		result = prime * result + account_id;
		result = prime * result + ((account_type == null) ? 0 : account_type.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Float.floatToIntBits(account_balance) != Float.floatToIntBits(other.account_balance))
			return false;
		if (account_id != other.account_id)
			return false;
		if (account_type == null) {
			if (other.account_type != null)
				return false;
		} else if (!account_type.equals(other.account_type))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_type=" + account_type + ", account_balance="
				+ account_balance + ", status=" + status + "]";
	}
	

	







	
	
	

}
