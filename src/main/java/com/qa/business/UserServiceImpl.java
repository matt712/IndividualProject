package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.repository.UserRepository;
import com.qa.util.JSONUtil;

public class UserServiceImpl implements UserService{
	@Inject
	private UserRepository repo;
	@Override
	public String createUser(String user) {
		return repo.createUser(user);
	}
	@Override
	public String getAUser(String username) {
		return repo.getAUser(username);
	}
	@Override
	public String getAllUsers() {
		return repo.getAllUsers();
	}
	@Override
	public String updateUser(String username, String user) {
		return repo.updateUser(username, user);
	}
	@Override
	public String deleteUser(String username) {
		return repo.deleteUser(username);
	}
	@Override
	public void setRepo(UserRepository repo2) {
		this.repo = repo2;
	}
}