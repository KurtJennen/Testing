package chapter4.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import chapter4.service.RegistrationService;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {
	@Mock
	private RegistrationService registrationService;
	
	private RegistrationController controller;
	
	@Before
	public void setup() {
		controller = new RegistrationController();
		controller.setRegistrationService(registrationService);
	}
	
	@Test
	public void when_invalid_user_id__genrates_error_message() {
		when(registrationService.hasError()).thenReturn("error");
		
		ModelMap model = new ModelMap();
		ModelAndView modelAndView = controller.onRegistration(model);
		
		String message = (String) modelAndView.getModel().get("message");
		
		assertNotNull(message);
		assertTrue(message.contains(RegistrationController.ERROR));
	}
	
	@Test
	public void when_valid_user_id_creates_user() {
		when(registrationService.hasError()).thenReturn(null);
		
		ModelMap model = new ModelMap();
		ModelAndView modelAndView = controller.onRegistration(model);
		
		String message = (String) modelAndView.getModel().get("message");
		
		assertNotNull(message);
		assertTrue(message.contains(RegistrationController.SUCCESS));
	}
}
