package chapter4.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chapter4.service.LoginService;

@Controller
public class LoginController {
	
	@Resource
	private LoginService loginService;
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping({"/", "/login"})
	public String onStartUp(ModelMap model) {
		return "login1";
	}
	
	@RequestMapping({"/onLogin"})
	public ModelAndView onLogin(ModelMap model) {
		if (!loginService.isValid()) {
			model.addAttribute("error", "Invalid user name and password");
			return new ModelAndView("login1", model);
		}
		
		String userName = loginService.retrieveName();
		model.addAttribute("name", "Welcome " + userName + "!");
		
		return new ModelAndView("greetings", model);
	}
	
}
