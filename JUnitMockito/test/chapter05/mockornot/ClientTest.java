package chapter05.mockornot;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {
//	final static String ANY_NUMBER = "999-888-777";
//	final static Phone MOBILE_PHONE = new Phone(ANY_NUMBER, true);
//	final static Phone STATIONARY_PHONE = new Phone(ANY_NUMBER, false);
	
	final static Phone MOBILE_PHONE = new Phone("+123456789");
	final static Phone STATIONARY_PHONE = new Phone("123123123");
	
	Client client = new Client();

	@Test
	public void shouldReturnTrueIfClientHasMobile() {
		client.addPhone(MOBILE_PHONE);
		client.addPhone(STATIONARY_PHONE);
		
		assertTrue(client.hasMobile());
	}
	
	@Test
	public void shouldReturnFalseIfClientHasNoMobile() {
		client.addPhone(STATIONARY_PHONE);
		
		assertFalse(client.hasMobile());
	}

}
