package chapter3.controller;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chapter3.model.LoginDetails;
import chapter3.model.LoginService;

@Controller
@Scope("session")
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LoginDetails loginDetails;

	@RequestMapping({"/", "/login"})
	public String onStartUp(ModelMap model) {
		return "login";
	}
	
	@RequestMapping({"/onLogin"})
	public ModelAndView onLogin(ModelMap model, HttpSession session, HttpServletRequest request) {
		if (!loginService.isValid()) {
			model.addAttribute("error", "Invalid user and password");
			return new ModelAndView("login", model);
		}
		
		session.setAttribute("loggedInTime", new Date());
		session.setAttribute("userId", request.getParameter("userId"));
		
		model.addAttribute("name", "Welcome reader!");
		
		return new ModelAndView("greetings", model);
	}
	
	@RequestMapping({ "/onLoginDetail" })
	public String onLoginDetail(ModelMap model) {
		model.addAttribute("name", loginDetails.getUser());
		model.addAttribute("time", loginDetails.getLoginTime());
		return "greetings";
	}
}
