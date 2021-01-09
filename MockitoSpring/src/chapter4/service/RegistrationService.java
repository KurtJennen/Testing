package chapter4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import chapter4.dao.RegistrationDAO;

public class RegistrationService {
	@Autowired
	private RegistrationDAO registrationDAO;
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	
	public void setRegistrationDAO(RegistrationDAO registrationDAO) {
		this.registrationDAO = registrationDAO;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String hasError() {
		if(isEmpty(userId)) {
			return "Please enter user id";
		}
		
		if(isEmpty(password)) {
			return "Please enter password";
		}
		
		if(isEmpty(firstName)) {
			return "Please enter first name";
		}
		
		if(isEmpty(lastName)) {
			return "Please enter last name";
		}
		
		if(isSpecial(firstName) || isSpecial(lastName)) {
			return "Name cannot contain special characters";
		}
		
		if (isNumeric(firstName) || isNumeric(lastName)) {
			return "Name cannot contain numbers";
		}
		
		if (!isSpecial(password)) {
			return "Password should contain a special character";
		}
		
		if (registrationDAO.isExistingUserId(userId)) {
			return "User Id exists";
		}
		
		try {
			registrationDAO.create(userId, password, firstName, lastName);
		} catch (Exception e) {
			return "Could not create user";
		}
		
		return null;
	}

	private boolean isEmpty(String value) {
		if( StringUtils.isEmpty(value)) {
			return true;
		}
		return false;
	}
	
	private boolean isSpecial(String value) {
		for(byte b : value.getBytes()) {
			if ((b < 97 || b > 122) && (b < 65 || b > 90) && (b < 48 || b > 57)){
				return true;
			}
				
		}
		return false;
	}
	
	private boolean isNumeric(String value) {
		for(byte b : value.getBytes()) {
			if (b > 48 && b < 57){
				return true;
			}
				
		}
		return false;
	}
}
