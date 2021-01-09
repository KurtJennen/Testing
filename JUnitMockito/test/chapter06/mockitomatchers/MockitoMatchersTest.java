package chapter06.mockitomatchers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class MockitoMatchersTest {

	@Test
	public void userOfMatchers() {
		UserDAO userDAO = mock(UserDAO.class);
		User user = new User();
		
		when(userDAO.getUser(anyInt())).thenReturn(user);
		
		assertEquals(user, userDAO.getUser(1));
		assertEquals(user, userDAO.getUser(2));
		assertEquals(user, userDAO.getUser(3));
		
		verify(userDAO, times(3)).getUser(anyInt());
		
	}
	
}
