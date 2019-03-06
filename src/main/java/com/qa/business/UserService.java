package com.qa.business;

import java.security.NoSuchAlgorithmException;

import com.qa.persistence.repository.UserRepository;
import com.qa.util.JSONUtil;

public interface UserService {
	//C
	String createUser(String user) throws NoSuchAlgorithmException;
	String loginUser(String user) throws NoSuchAlgorithmException;
	//R
	String getAUser(String username);
	String getAllUsers();
	//U
	String updateUserPassword(String username, String newPassword) throws NoSuchAlgorithmException;
	//D
	String deleteUser(String username);
	//set method
	void setRepo(UserRepository repo);

}
