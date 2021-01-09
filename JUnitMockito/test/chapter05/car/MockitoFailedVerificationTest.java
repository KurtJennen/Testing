package chapter05.car;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class MockitoFailedVerificationTest {
	
	private Car myFerrari = mock(Car.class);
	
	@Test
	public void testVerificationFailure() {
		myFerrari.getEngineTemperature();
		
		verify(myFerrari).needsFuel();
	}
	
}
