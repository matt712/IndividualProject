package com.qa.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Default
@Transactional
public class UserDBRepository implements UserRepository{
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	@Inject
	private JSONUtil util;
	@Transactional
	public String createUser(String user) {
		User aUser = util.getObjectForJSON(user, User.class);
		em.persist(aUser);
		return "{\"message\":\"User has been created\"}";
	}
	public String getAllUsers() {
		Query query = em.createQuery("Select a FROM User a");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}
	public String getAUser(String username) {
		return util.getJSONForObject(em.find(User.class, username));
	}
	@Transactional
	public String updateUser(String username, String newPassword) {
		User user1 = em.find(User.class, username);
		user1.setPassword(newPassword);
		return "{\"message\":\"User has been updated\"}";
	}
	@Transactional
	public String deleteUser(String username) {
		if(em.contains(em.find(User.class, username)))
		{
			em.remove(em.find(User.class, username));
		}
		return "{\"message\":\"User has been destroyed\"}";
	}

	public void setEm(EntityManager em2) {
		this.em = em2;
	}

	public void setUtil(JSONUtil util2) {
		this.util = util2;
	}
}