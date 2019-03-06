package com.qa.business;

import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserRepository;
import com.qa.util.HashUtil;
import com.qa.util.JSONUtil;

public class UserServiceImpl implements UserService{
	@Inject
	private UserRepository repo;
	@Inject
	private JSONUtil util;
	@Inject
	private HashUtil hash;
	public String createUser(String user) throws NoSuchAlgorithmException {
		util = new JSONUtil();
		User aUser = util.getObjectForJSON(user, User.class);
		String oldPassword = aUser.getPassword();
		System.out.println(oldPassword);
		if(oldPassword.length()<8) {
			return "{\"message\":\"Passwords require at least 8 characters\"}";
		}else {
			aUser.setPassword(hash.createHash(oldPassword));
			System.out.println(aUser.getPassword());
			user = util.getJSONForObject(aUser);
			System.out.println(user);
			return repo.createUser(user);
		}
	}
	public String loginUser(String user) throws NoSuchAlgorithmException {
		util = new JSONUtil();
		User aUser = util.getObjectForJSON(user, User.class);
		User user2 = util.getObjectForJSON(repo.getAUser(aUser.getUsername()), User.class);
		String password = aUser.getPassword();
		String hashedPassword = hash.createHash(password);
		if(hashedPassword.equals(user2.getPassword())) {
			return "{\"message\":\"Correct Password\"}";
		}else {
			return "{\"message\":\"Incorrect Password\"}";
		}
	}
	public String getAUser(String username) {
		return repo.getAUser(username);
	}
	public String getAllUsers() {
		return repo.getAllUsers();
	}
	public String updateUserPassword(String username, String newPassword) throws NoSuchAlgorithmException {
		if(newPassword.length()<8) {
			return "{\"message\":\"Passwords require at least 8 characters\"}";
		}
		String hashedPassword = hash.createHash(newPassword);
		return repo.updateUserPassword(username, hashedPassword);
	}
	public String deleteUser(String username) {
		return repo.deleteUser(username);
	}
	public void setRepo(UserRepository repo2) {
		this.repo = repo2;
	}
}