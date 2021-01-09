package chapter4.dao;

public interface RegistrationDAO {
	boolean isExistingUserId(String userId);
	void create(String userId, String password, String firstName, String lastName);
	String retrieveName(String userId);
}
