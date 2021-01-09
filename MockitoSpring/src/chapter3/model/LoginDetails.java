package chapter3.model;

import java.util.Date;

public class LoginDetails {

	private String user;
	private Date loginTime;
	
	public String getUser() {
		return user;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public LoginDetails(String user, Date loginTime) {
		this.user = user;
		this.loginTime = loginTime;
	}
	
}
