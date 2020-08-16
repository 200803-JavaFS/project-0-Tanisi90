package com.revature.daos;

import java.util.List;
import com.revature.models.Users;

public interface UsersIDAO {
	
public List<Users> findAll();
	
	public Users findById(int id);
	
	public boolean addUser(Users a);
	
	public boolean updateUser(Users a); 
	

}
