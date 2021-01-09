package chapter06.collections;

import java.util.ArrayList;
import java.util.List;

public class User {
	private final List<String> phones = new ArrayList<String>();
	
	public void addPhone(String phone) {
		phones.add(phone);
	}

	public List<String> getPhones() {
		return phones;
	}
}
