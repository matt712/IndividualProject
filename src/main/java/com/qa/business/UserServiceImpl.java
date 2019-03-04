package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserRepository;
import com.qa.util.JSONUtil;

public class UserServiceImpl implements UserService{
	@Inject
	private UserRepository repo;
	@Inject
	private JSONUtil util;
	public String createUser(String user) {
		return repo.createUser(user);
	}
	public String getAUser(String username) {
		return repo.getAUser(username);
	}
	public String getAllUsers() {
		return repo.getAllUsers();
	}
	public String updateUserPassword(String username, String newPassword) {
		if(newPassword.length()<8) {
			return "{\"message\":\"Passwords require at least 8 characters\"}";
		}
		return repo.updateUserPassword(username, newPassword);
	}
	public String deleteUser(String username) {
		return repo.deleteUser(username);
	}
	public void setRepo(UserRepository repo2) {
		this.repo = repo2;
	}
}