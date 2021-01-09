package chapter07.privatemethods;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class PrivateMethodPowermockTest {

	@Test
	public void testingPrivateMethodWithReflection() throws Exception {
		SomeClass sut = new SomeClass();
		
		Boolean result = Whitebox.invokeMethod(sut, "privateMethod", 302483L);
		
		assertTrue(result);
	}
	
}
