package chapter4.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import chapter4.service.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	@Mock
	private LoginService loginService;
	
	private LoginController controller;
	
	@Before
	public void setup() {
		controller = new LoginController();
		controller.setLoginService(loginService);
	}
	
	@Test
	public void when_invalid_login_error_message_is_generated() {
		when(loginService.isValid()).thenReturn(false);
		
		ModelMap model = new ModelMap();
		ModelAndView modelAndView = controller.onLogin(model);
		
		assertNotNull(modelAndView.getModel().get("error"));
		assertEquals("login1", modelAndView.getViewName());
	}
	
	@Test
	public void when_valid_login_error_message_is_generated() {
		when(loginService.isValid()).thenReturn(true);
		
		ModelMap model = new ModelMap();
		ModelAndView modelAndView = controller.onLogin(model);
		
		assertNull(modelAndView.getModel().get("error"));
		assertNotNull(modelAndView.getModel().get("name"));
		assertEquals("greetings", modelAndView.getViewName());
	}
}
