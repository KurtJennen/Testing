package chapter03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {

	private Address addressA = new Address("street A");
	private Address addressB = new Address("street B");
	private Client client;
	
	@Before
	public void setUp() {
		client = new Client();
	}
	
	@Test
	public void afterCreationShouldHaveNoAdress() {
		assertEquals(0,  client.getAddresses().size());
	}
	
	@Test
	public void shouldAllowToAddAddress() {
		client.addAddresses(addressA);
		
		assertEquals(1,  client.getAddresses().size());
		assertTrue(client.getAddresses().contains(addressA));
	}
	
	@Test
	public void shouldAllowToAddManyAddresses() {
		client.addAddresses(addressA);
		client.addAddresses(addressB);
		
		assertEquals(2,  client.getAddresses().size());
		assertTrue(client.getAddresses().contains(addressA));
		assertTrue(client.getAddresses().contains(addressB));
	}
}
