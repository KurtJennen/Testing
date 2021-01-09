package chapter06.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void shouldReturnUsersPhone() {
		User user = new User();
		user.addPhone("123 456 789");
		
		List<String> phones = user.getPhones();
		
		assertNotNull(phones);
		assertEquals(1, phones.size());
		assertTrue(phones.contains("123 456 789"));
	}

}
