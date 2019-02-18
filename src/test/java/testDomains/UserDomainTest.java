package testDomains;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.persistence.domain.User;

public class UserDomainTest {

	User user1 = new User();
	@Test
	public void testUsernames() {
		user1.setUsername("JDCR");
		assertEquals("JDCR", user1.getUsername());
	}
	@Test 
	public void testPasswords()
	{
		user1.setPassword("password");
		assertEquals("password", user1.getPassword());
	}
}
