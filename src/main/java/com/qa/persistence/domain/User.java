package com.qa.persistence.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User 
{
	@Id
	private String username;
	@Column
	private String password;
	@OneToMany(mappedBy="username")
	private Set<MatchUpNote> notes;
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
