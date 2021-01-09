package chapter06.mockitomatchers;

import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MockitoHamcrestMatchersTest {

	@SuppressWarnings("unchecked")
	@Test
	public void userOfHamcestMatchers() {
		UserDAO userDAO = mock(UserDAO.class);
		User user = new User();
		
		when(userDAO.getUserByProperties((Map<String, String>) argThat(hasEntry("id", "2")))).thenReturn(user);
		
		assertNull(userDAO.getUserByProperties(new HashMap<String, String>()));
		
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("id", "2");
		
		assertEquals(user, userDAO.getUserByProperties(properties));
		
	}
	
}
