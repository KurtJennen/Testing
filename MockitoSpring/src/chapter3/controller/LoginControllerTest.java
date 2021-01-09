package chapter3.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import chapter3.model.LoginDetails;
import chapter3.model.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:dispatcher-servlet.xml")
@WebAppConfiguration
public class LoginControllerTest {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LoginDetails loginDetails;
	
	@Autowired
	private MockHttpServletRequest request;
	
	@Autowired
	private MockHttpSession session;
	
	@Test
	public void requestScope() throws Exception {
		request.setParameter("userId", "rock");
		request.setParameter("password", "rock");
		
		assertTrue(loginService.isValid());
	}
	
	@Test
	public void sessionScope() throws Exception {
		Date now = new Date(); 
		session.setAttribute("userId", "john");
		session.setAttribute("loggedInTime", now);
		
		assertEquals("john", loginDetails.getUser());
		assertEquals(now, loginDetails.getLoginTime());
	}
}
