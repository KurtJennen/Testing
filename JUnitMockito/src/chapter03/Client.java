package chapter03;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private List<Address> addresses = new ArrayList<Address>();
	
	public Client() {
	}
	
	public Client(Address address) {
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void addAddresses(Address address) {
		addresses.add(address);
	}
	
}
