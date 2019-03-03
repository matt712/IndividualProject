package testRepositories;

import static org.junit.Assert.*;
import org.junit.Test;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserDBRepository;
import com.qa.util.JSONUtil;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryDBTest {

	@InjectMocks
	private UserDBRepository repo;
	@Mock
	private EntityManager em;
	@Mock 
	private Query query;
	private JSONUtil util;
	private static final String MOCK_DATA_ARRAY = "[{\"username\":\"JDCR\",\"password\":\"Bob\"}]";
	private static final String MOCK_OBJECT = "{\"username\":\"JDCR\",\"password\":\"Bob\"}";
	@Before
	public void setUp()
	{
		repo.setEm(em);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	@Test
	public void testCreateUser() {
		String reply = repo.createUser(MOCK_OBJECT);
		assertEquals(reply, "\"message\":\"User has been created\"");
	}
	@Test
	public void testGetAllUsers() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<User>();
		users.add(new User("JDCR", "Bob"));
		Mockito.when(query.getResultList()).thenReturn(users);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllUsers());
	}
	@Test
	public void testGetAUser() {
		Mockito.when(em.find(User.class, "JDCR")).thenReturn(util.getObjectForJSON(MOCK_OBJECT, User.class));
		assertEquals(MOCK_OBJECT, repo.getAUser("JDCR"));
	}
	@Test
	public void testUpdateUser() {
		User aUser = util.getObjectForJSON(MOCK_OBJECT, User.class);
		Mockito.when(em.find(User.class, "JDCR")).thenReturn(aUser);
		String reply = repo.updateUser("JDCR", MOCK_OBJECT);
		assertEquals(reply, "\"message\":\"User has been updated\"");
	}
	@Test
	public void testDeleteUser() {
		String reply = repo.deleteUser(MOCK_OBJECT);
		assertEquals(reply, "\"message\":\"User has been destroyed\"");
	}
}
