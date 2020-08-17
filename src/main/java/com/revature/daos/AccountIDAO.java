package com.revature.daos;

import java.util.List;
import com.revature.models.Account;

public interface AccountIDAO {
	
public List<Account> findAll();
	
	public Account findById(int id);
	
	public int addAccount(Account a);
	
	public boolean updateAccount(Account a); 
	
	public boolean closeAccount(int account_id);

	public boolean openAccount(int account_id);


}
