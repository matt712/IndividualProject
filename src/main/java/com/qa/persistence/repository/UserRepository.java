package com.qa.persistence.repository;

public interface UserRepository 
{
	//C
	String createUser(String user);
	//R
	String getAUser(String username);
	String getAllUsers();
	//U
	String updateUser(String username, String user);
	//D
	String deleteUser(String username);
}
