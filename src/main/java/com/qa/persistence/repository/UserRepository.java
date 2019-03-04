package com.qa.persistence.repository;

public interface UserRepository 
{
	//C
	String createUser(String user);
	//R
	String getAUser(String username);
	String getAllUsers();
	//U
	String updateUserPassword(String username, String newPassword);
	//D
	String deleteUser(String username);
}
