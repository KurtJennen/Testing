package chapter05.mockornot;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class ClientTest1 {
	final static Phone MOBILE_PHONE = mock(Phone.class);
	final static Phone STATIONARY_PHONE = mock(Phone.class);
	
	Client client = new Client();

	@Test
	public void shouldReturnTrueIfClientHasMobile() {
		client.addPhone(MOBILE_PHONE);
		client.addPhone(STATIONARY_PHONE);
		
		when(MOBILE_PHONE.isMobile()).thenReturn(true);

		assertTrue(client.hasMobile());
	}
	
	@Test
	public void shouldReturnFalseIfClientHasNoMobile() {
		client.addPhone(STATIONARY_PHONE);
		
		assertFalse(client.hasMobile());
	}

}
