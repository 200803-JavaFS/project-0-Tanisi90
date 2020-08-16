package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtility;

public class AccountDAO implements AccountIDAO {


	@Override
	public List<Account> findAll() {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM Account;";

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
	public Account findById(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM Account WHERE account_id =" + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				Account a = new Account(result.getInt("account_id"), result.getString("account_type"), 
						result.getFloat("account_balance"),result.getBoolean("status"));
				return a;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		try (Connection conn = ConnectionUtility.getConnection()) {

			String sql = "INSERT INTO Account (account_balance, account_type, status)"
					+ "VALUES (?, ?, ?);";

			PreparedStatement statement = conn.prepareStatement(sql);

		int index = 0;
		statement.setFloat(++index, a.getAccount_balance());
		statement.setString(++index, a.getAccount_type());
		statement.setBoolean(++index, a.isStatus());
//			if(a.getHomeBase()!=null) {
//				Home h = a.getHomeBase();
//				statement.setString(++index, h.getHomeBase());
//			}else {
//				statement.setString(++index, null);
//			}

			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAccount(Account a) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE Account SET account_balance = ?, account_type = ?, status= ? ";
					
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setFloat(++index, a.getAccount_balance());
			statement.setString(++index, a.getAccount_type());
			statement.setBoolean(++index, a.isStatus());
//			if(a.getHomeBase()!=null) {
//				Home h = a.getHomeBase();
//				statement.setString(++index, h.getHomeBase());
//			}else {
//				statement.setString(++index, null);
//			}
//			statement.setInt(++index, a.getSupId());
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean closeAccount(int account_id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE account SET status = FALSE WHERE account_id =" + account_id + ";";

			Statement statement = conn.createStatement();

			statement.execute(sql);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}


