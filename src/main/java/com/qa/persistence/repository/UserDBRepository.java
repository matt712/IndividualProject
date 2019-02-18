package com.qa.persistence.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

public class UserDBRepository implements UserRepository{

	private EntityManager em;
	private JSONUtil util;
	public String createUser(String user) {
		User aUser = util.getObjectForJSON(user, User.class);
		em.persist(aUser);
		return "\"message\":\"User has been created\"";
	}
	public String getAllUsers() {
		Query query = em.createQuery("Select a FROM User a");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}
	public String getAUser(String username) {
		return util.getJSONForObject(em.find(User.class, username));
	}

	public String updateUser(String username, String user) {
		deleteUser(username);
		createUser(user);
		return "\"message\":\"User has been updated\"";
	}
	public String deleteUser(String username) {
		if(em.contains(em.find(User.class, username)))
		{
			em.remove(em.find(User.class, username));
		}
		return "\"message\":\"User has been destroyed\"";
	}

	public void setEm(EntityManager em2) {
		this.em = em2;
	}

	public void setUtil(JSONUtil util2) {
		this.util = util2;
	}
}