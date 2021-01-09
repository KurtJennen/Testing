package chapter05.car;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class MockitoFailedVerificationArgumentsTest {
	
	private Car myFerrari = mock(Car.class);
	
	@Test
	public void testVerificationFailureArguments() {
		myFerrari.driveTo("Sweet home Alabama");
		
		verify(myFerrari).driveTo("Sweet home Honolulu");
	}
	
}
