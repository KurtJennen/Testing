package chapter4.service;

import org.springframework.beans.factory.annotation.Autowired;

import chapter4.dao.RegistrationDAO;

public class LoginService {
	@Autowired
	private RegistrationDAO registrationDAO;
	private String userId;
	private String password;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isValid() {
		return registrationDAO.isExistingUserId(userId);
	}
	
	public String retrieveName() {
		return registrationDAO.retrieveName(userId);
	}
}
