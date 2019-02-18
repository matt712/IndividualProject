package com.qa.persistence.domain;

public class User 
{
	private String username;
	private String password;
	public User()
	{
	}
	public User(String username2, String password2)
	{
		this.username = username2;
		this.password = password2;
	}
	public void setUsername(String usernameNew)
	{
		this.username = usernameNew;
	}
	public String getUsername()
	{
		return username;
	}
	public void setPassword(String newPassword) 
	{
		this.password = newPassword;
	}
	public Object getPassword() 
	{
		return password;
	}
}
