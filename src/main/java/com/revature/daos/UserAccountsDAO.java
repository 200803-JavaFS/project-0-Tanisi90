package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtility;

public class UserAccountsDAO implements UserAccountsIDAO {

	@Override
	public List<Account> findUserAccounts(int user_id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT  account.* FROM user_accounts "
					+ "JOIN account ON account.account_id = user_accounts.account_id_fk "
					+ "WHERE user_id_fk =" + user_id + "AND account.status = TRUE;";

			Statement statement = conn.createStatement();

			List<Account> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Account a = new Account(result.getInt("account_id"), result.getString("account_type"), 
						result.getFloat("account_balance"),result.getBoolean("status"));
				list.add(a);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Users> findAccountUsers(int account_id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			
			String sql = "SELECT users.* FROM user_accounts  "
					+ "JOIN users ON users.user_id = user_accounts.user_id_fk "
					+ "WHERE account_id_fk = " + account_id + ";";

			Statement statement = conn.createStatement();

			List<Users> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Users u = new Users(result.getInt("user_id"), result.getString("username"), result.getString("password"), 
						result.getString("first_name"),result.getString("last_name"), result.getString("address"),
								result.getString("city"), result.getString("state"), result.getString("zip"),
										result.getString("email"), result.getString("social_namuber"));
				list.add(u);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void addAccountToUser(int user_id, int account_id) {
		try (Connection conn = ConnectionUtility.getConnection()){
			String sql = "INSERT INTO user_accounts (user_id_fk , account_id_fk )"
					+ "VALUES (" + user_id + "," + account_id + ");";
			
			Statement statement = conn.createStatement();
			
			statement.executeQuery(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return;
	}
		

	@Override
	public void removeAccountUser(int user_id, int account_id) {
		
		try (Connection conn = ConnectionUtility.getConnection()){
			String sql = "DELETE FROM user_accounts WHERE user_id_fk =" +  user_id + " AND account_id_fk =" + account_id + ";";
			
			Statement statement = conn.createStatement();
			
			statement.executeQuery(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
	

}
