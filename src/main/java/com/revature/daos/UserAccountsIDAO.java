package com.revature.daos;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.Users;

public interface UserAccountsIDAO {
	
	public List<Account> findUserAccounts(int user_id);
	
	public List<Users> findAccountUsers(int account_id);
	
	public void addAccountToUser(int user_id, int account_id);
	
	public void removeAccountUser(int user_id, int account_id);
	

}
