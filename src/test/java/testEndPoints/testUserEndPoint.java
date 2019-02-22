package testEndPoints;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.UserService;
import com.qa.rest.UserEndPoint;

@RunWith(MockitoJUnitRunner.class)
public class testUserEndPoint {
	
	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";
	private static final int MOCK_ID = 1;
	@InjectMocks
	private UserEndPoint endy;
	@Mock
	private UserService serv;
	@Before
	public void setUp() {
		endy.setService(serv);
	}
	@Test
	public void testCreateUser() {
		Mockito.when(serv.createUser(MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endy.createUser(MOCK_VALUE));
	}
	@Test
	public void getAllUsers() {
		Mockito.when(serv.getAllUsers()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endy.getAllUsers());
	}
	@Test
	public void getAUser() {
		Mockito.when(serv.getAUser(MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endy.getAUser(MOCK_VALUE));
	}
	@Test
	public void updateUser() {
		Mockito.when(serv.updateUser(MOCK_VALUE, MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endy.updateUser(MOCK_VALUE, MOCK_VALUE));
	}
	@Test
	public void deleteUser() {
		Mockito.when(serv.deleteUser(MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endy.deleteUser(MOCK_VALUE));
	}
}
