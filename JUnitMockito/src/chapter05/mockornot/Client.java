package chapter05.mockornot;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private final List<Phone> phones = new ArrayList<Phone>();
	
	public void addPhone(Phone phone) {
		phones.add(phone);
	}

	public boolean hasMobile() {
		for (Phone phone : phones) {
			if (phone.isMobile()) {
				return true;
			}
		}
		
		return false;
	}
}
