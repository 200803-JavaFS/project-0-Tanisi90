package com.revature.daos;

import java.util.List;
import com.revature.models.Users;

public interface UsersIDAO {
	
public List<Users> findAll();
	
	public Users findById(int id);
	
	public int addUser(Users a);
	
	public boolean updateUser(Users a);

	public Users findUsername(String username); 
	
	public Users findPassword(String password);
	
	public Users findUser(String username, String password);
	
	public Users findUserByName(String username);


}
