package chapter4.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationDaoSpringTest {

	@Mock
	JdbcTemplate jdbcTemplate;
	
	RegistrationDaoSpring springDao;
	
	@Before
	public void init() {
		springDao = new RegistrationDaoSpring(jdbcTemplate);
	}
	
	@Test
	public void when_creates_user() throws Exception {
		String joesUserId = "joe4u";
		String joesPassword = "joe@123";
		String joesFirstName = "Joseph";
		String joesLastName = "Lawrence";
		
		when(jdbcTemplate.update(anyString(), anyObject(), anyObject(), anyObject(), anyObject())).thenReturn(1);
		
		springDao.create(joesUserId, joesPassword, joesFirstName, joesLastName);
		
		ArgumentCaptor<String> strArg = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Object> varArg = ArgumentCaptor.forClass(Object.class);
		
		verify(jdbcTemplate).update(strArg.capture(), varArg.capture(), varArg.capture(), varArg.capture(), varArg.capture());
	
		assertEquals(joesUserId, varArg.getAllValues().get(0));
		assertEquals(joesPassword, varArg.getAllValues().get(1));
		assertEquals(joesFirstName, varArg.getAllValues().get(2));
		assertEquals(joesLastName, varArg.getAllValues().get(3));
	}
	
	@Test(expected=RuntimeException.class)
	public void when_create_fails_then_raises_error() {
		String joesUserId = "joe4u";
		String joesPassword = "joe@123";
		String joesFirstName = "Joseph";
		String joesLastName = "Lawrence";
		
		when(jdbcTemplate.update(anyString(), anyObject(), anyObject(), anyObject())).thenReturn(0);
		
		springDao.create(joesUserId, joesPassword, joesFirstName, joesLastName);
	}
}
