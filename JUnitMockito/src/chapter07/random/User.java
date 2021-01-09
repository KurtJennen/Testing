package chapter07.random;

public class User {

	private String name;
	private String surname;

	public User(String title, String surname) {
		this.name = title;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
}
