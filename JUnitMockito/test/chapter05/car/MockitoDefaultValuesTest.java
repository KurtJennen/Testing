package chapter05.car;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class MockitoDefaultValuesTest {
	
	private Car myFerrari = mock(Car.class);
	
	@Test
	public void testDefaultBehaviourOfTestDouble() {
		assertFalse("new test double should return false as boolean", myFerrari.needsFuel());
		assertEquals("new test double should return 0.0 as double", 0.0d, myFerrari.getEngineTemperature(), 0);
	}
	
}
