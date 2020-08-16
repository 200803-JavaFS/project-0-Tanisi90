package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Users;
import com.revature.utils.ConnectionUtility;

public class UsersDAO implements UsersIDAO {


	@Override
	public List<Users> findAll() {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM Users;";

			Statement statement = conn.createStatement();

			List<Users> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Users a = new Users(result.getInt("user_id"), result.getString("username"), result.getString("password"), 
						result.getString("first_name"),result.getString("last_name"), result.getString("address"),
								result.getString("city"), result.getString("state"), result.getString("zip"),
										result.getString("email"), result.getString("social_namuber"));
				list.add(a);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Users findById(int user_id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users WHERE users_id =" + user_id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				Users u = new Users(result.getInt("user_id"), result.getString("username"), result.getString("password"), 
						result.getString("first_name"),result.getString("last_name"), result.getString("address"),
								result.getString("city"), result.getString("state"), result.getString("zip"),
										result.getString("email"), result.getString("social_namuber"));
				return u;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(Users a) {
		try (Connection conn = ConnectionUtility.getConnection()) {

			String sql = "INSERT INTO users (username, password, first_name, last_name, address, city, state, zip, email, social_number)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement statement = conn.prepareStatement(sql);

		int index = 0;
		statement.setString(++index, a.getUsername());
		statement.setString(++index, a.getPassword());
		statement.setString(++index, a.getFirst_name());
		statement.setString(++index, a.getLast_name());
		statement.setString(++index, a.getAddress());
		statement.setString(++index, a.getCity());
		statement.setString(++index, a.getState());
		statement.setString(++index, a.getZip());
		statement.setString(++index, a.getEmail());
		statement.setString(++index, a.getSocial_number());
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
	public boolean updateUser(Users a) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE users SET first_name = ?, last_name = ?, address = ?, city = ?, state = ?, zip = ?, email = ?"; 
					
					
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, a.getFirst_name());
			statement.setString(++index, a.getLast_name());
			statement.setString(++index, a.getAddress());
			statement.setString(++index, a.getCity());
			statement.setString(++index, a.getState());
			statement.setString(++index, a.getZip());
			statement.setString(++index, a.getEmail());
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

	public Users findUser(String username, String password) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM Users WHERE username = " + username + "AND password = " + password + ";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			if (result.next()) {
				Users u = new Users(result.getInt("user_id"), result.getString("username"), result.getString("password"), 
						result.getString("first_name"),result.getString("last_name"), result.getString("address"),
								result.getString("city"), result.getString("state"), result.getString("zip"),
										result.getString("email"), result.getString("social_namuber"));
				return u;
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		System.out.println("Unable to find username or password doesn't match. Please try again!");
		return null;
	}
}

	
	
	




