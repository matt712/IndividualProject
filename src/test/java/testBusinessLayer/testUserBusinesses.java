package testBusinessLayer;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.UserService;
import com.qa.business.UserServiceImpl;
import com.qa.persistence.repository.UserRepository;
import com.qa.util.HashUtil;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class testUserBusinesses {

	private static final String MOCK_OBJECT1 = "{\"username\":\"JDCR\",\"password\":\"iplaybob\"}";
	private static final String MOCK_OBJECT2 = "{\"username\": \"KNEE\", \"password\": \"iplayBryan\"}";
	private static final String MOCK_VALUE = "test_value_2";
	private static final String MOCK_RESPONSE = "{\"message\":\"Correct Password\"}";
	private static final String MOCK_RESPONSE2 = "{\"message\":\"Incorrect Password\"}";
	private static final String MOCK_ID = "JDCR";
	@InjectMocks
	private UserServiceImpl serv;
	@Mock
	private UserRepository repo;
	@Mock
	private JSONUtil util;
	@Mock
	private HashUtil hash;
	@Before
	public void setUp(){
		serv.setRepo(repo);
	}
	@Test
	public void testCreateUser() throws NoSuchAlgorithmException {
		Mockito.when(hash.createHash(Mockito.anyString())).thenReturn("iplaybob");
		Mockito.when(repo.createUser(MOCK_OBJECT1)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.createUser(MOCK_OBJECT1));
	}
	@Test
	public void testLoginUser() throws NoSuchAlgorithmException {
		Mockito.when(hash.createHash(Mockito.anyString())).thenReturn("iplayBryan");
		Mockito.when(repo.getAUser("KNEE")).thenReturn(MOCK_OBJECT2);
		assertEquals(MOCK_RESPONSE, serv.loginUser(MOCK_OBJECT2));
	}
	@Test
	public void testLoginFail() throws NoSuchAlgorithmException {
		Mockito.when(hash.createHash(Mockito.anyString())).thenReturn("iplaybob");
		Mockito.when(repo.getAUser("JDCR")).thenReturn(MOCK_OBJECT2);
		assertEquals(MOCK_RESPONSE2, serv.loginUser(MOCK_OBJECT1));
	}
	@Test
	public void testGetAllUsers() {
		Mockito.when(repo.getAllUsers()).thenReturn(MOCK_OBJECT1);
		assertEquals(MOCK_OBJECT1, serv.getAllUsers());
	}
	@Test
	public void testGetAUser() {
		Mockito.when(repo.getAUser(MOCK_ID)).thenReturn(MOCK_OBJECT1);
		assertEquals(MOCK_OBJECT1, serv.getAUser(MOCK_ID));
	}
	@Test
	public void testUpdateUser() throws NoSuchAlgorithmException {
		Mockito.when(hash.createHash(MOCK_OBJECT1)).thenReturn(MOCK_OBJECT1);
		Mockito.when(repo.updateUserPassword(MOCK_ID, MOCK_OBJECT1)).thenReturn(MOCK_OBJECT2);
		assertEquals(MOCK_OBJECT2, serv.updateUserPassword(MOCK_ID, MOCK_OBJECT1));
	}
	@Test
	public void testUpdateUserPasswordTooShort() throws NoSuchAlgorithmException {
		Mockito.when(repo.updateUserPassword(MOCK_ID, MOCK_ID)).thenReturn(MOCK_OBJECT2);
		String reply = "{\"message\":\"Passwords require at least 8 characters\"}";
		assertEquals(reply, serv.updateUserPassword(MOCK_ID, MOCK_ID));
	}
	@Test
	public void testDeleteUser() {
		Mockito.when(repo.deleteUser(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.deleteUser(MOCK_ID));
	}
}
