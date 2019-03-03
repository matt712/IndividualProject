package com.qa.business;

import com.qa.persistence.repository.UserRepository;
import com.qa.util.JSONUtil;

public interface UserService {
	//C
	String createUser(String user);
	//R
	String getAUser(String username);
	String getAllUsers();
	//U
	String updateUser(String username, String newPassword);
	//D
	String deleteUser(String username);
	//set method
	void setRepo(UserRepository repo);

}
