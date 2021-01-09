package chapter4.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import chapter4.dao.RegistrationDAO;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceImplTest {
	
	public static final String PLEASE_ENTER_USER_ID = "Please enter user id";
	public static final String PLEASE_ENTER_PASSWORD = "Please enter password";
	public static final String PLEASE_ENTER_FIRST_NAME = "Please enter first name";
	public static final String PLEASE_ENTER_LAST_NAME = "Please enter last name";
	public static final String NAME_CONTAINS_NUMBER = "Name cannot contain numbers";
	public static final String NAME_CONTAINS_SPECIAL_CHAR = "Name cannot contain special characters";
	public static final String USER_ID_EXISTS = "User Id exists";
	public static final String COULD_NOT_CREATE_USER = "Could not create user";
	
	@Mock
	private RegistrationDAO registrationDAO;
	
	private RegistrationService registrationService;
	
	@Before
	public void setup() {
		registrationService = new RegistrationService();
		registrationService.setRegistrationDAO(registrationDAO);
	}
	
	@Test
	public void when_empty_inputs_raises_error() {
		String error = registrationService.hasError();
		assertNotNull(error);
		assertEquals(PLEASE_ENTER_USER_ID, error);
		
		registrationService.setUserId("john123");
		error = registrationService.hasError();
		assertNotNull(error);
		assertEquals(PLEASE_ENTER_PASSWORD, error);
		
		registrationService.setPassword("Passw@rd");
		error = registrationService.hasError();
		assertNotNull(error);
		assertEquals(PLEASE_ENTER_FIRST_NAME, error);
		
		registrationService.setFirstName("john");
		error = registrationService.hasError();
		assertNotNull(error);
		assertEquals(PLEASE_ENTER_LAST_NAME, error);
		
		registrationService.setLastName("doe");
		error = registrationService.hasError();
		assertNull(error);
	}
	
	@Test
	public void when_name_contains_number_raises_error() {
		registrationService.setFirstName("john1");
		registrationService.setLastName("doe");
		registrationService.setUserId("john123");
		registrationService.setPassword("Passw@rd");
		
		String error = registrationService.hasError();
		assertNotNull(error);
		assertEquals(NAME_CONTAINS_NUMBER, error);
	}
	
	@Test
	public void when_name_contains_special_chars_raises_error() {
		registrationService.setFirstName("john@");
		registrationService.setLastName("doe");
		registrationService.setUserId("john123");
		registrationService.setPassword("Passw@rd");
		
		String error = registrationService.hasError();
		assertNotNull(error);
		assertEquals(NAME_CONTAINS_SPECIAL_CHAR, error);
	}
	
	@Test
	public void when_user_exists_raises_error() {
		when(registrationDAO.isExistingUserId(Mockito.anyString())).thenReturn(true);
		registrationService.setFirstName("john");
		registrationService.setLastName("doe");
		registrationService.setUserId("john123");
		registrationService.setPassword("Passw@rd");
		
		String error = registrationService.hasError();
		assertNotNull(error);
		assertEquals(USER_ID_EXISTS, error);
	}
	
	@Test
	public void when_user_creation_fails_raises_error() {
		doThrow(new RuntimeException("save failed")).when(registrationDAO).create(anyString(), anyString(), anyString(), anyString());
		registrationService.setFirstName("john");
		registrationService.setLastName("doe");
		registrationService.setUserId("john123");
		registrationService.setPassword("Passw@rd");
		
		String error = registrationService.hasError();
		assertNotNull(error);
		assertEquals(COULD_NOT_CREATE_USER, error);
	}
	
	@Test
	public void when_no_validation_error_then_creates_user() {
		registrationService.setFirstName("john");
		registrationService.setLastName("doe");
		registrationService.setUserId("john123");
		registrationService.setPassword("Passw@rd");
		
		String error = registrationService.hasError();
		assertNull(error);
	}
}
