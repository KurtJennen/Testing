package chapter4.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chapter4.service.RegistrationService;

@Controller
public class RegistrationController {
	public static final String ERROR = "Cannot create the user due to following error";
	public static final String SUCCESS = "User created";
	
	@Resource
	private RegistrationService registrationService;
	
	public void setRegistrationService(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	@RequestMapping({"/register"})
	public String showRegisterView(ModelMap model) {
		return "register1";
	}
	
	@RequestMapping({"/onRegistration"})
	public ModelAndView onRegistration(ModelMap model) {
		String error = registrationService.hasError();
		if(error != null) {
			model.addAttribute("message", "Cannot create the user due to following error = " + error);
		} else {
			model.addAttribute("message", "User created");
		}
		return new ModelAndView("register1", model);
	}
	
	
}
