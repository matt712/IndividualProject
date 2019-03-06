package testUtilities;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import com.qa.util.HashUtil;

public class TestHash {

	private HashUtil hash;
	@Before
	public void setUp() {
		hash = new HashUtil();
	}
	@Test
	public void testhash() throws NoSuchAlgorithmException {
		String result = hash.createHash("Barry");
		System.out.println(result);
		assertEquals(result, "314b70945d85e6929db47ba8b4afb9765f5c5e98476a2ffd1f2ee74aaf106d5d166c1b2c730240ddb678a5f63198fd7f85894ec872d9738091d6273bb363ca9b");
	}
	

}
