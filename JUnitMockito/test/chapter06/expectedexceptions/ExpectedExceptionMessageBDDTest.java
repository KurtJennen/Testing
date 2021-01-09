package chapter06.expectedexceptions;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExpectedExceptionMessageBDDTest {
	Phone phone = new Phone();

	@Test
	public void shouldThrowIAEForEmptyNumber() {
		catchException(phone).setNumber(null);
		
		assertTrue(caughtException() instanceof IllegalArgumentException);
		assertEquals("number can not be null or empty", caughtException().getMessage());
	}
	
	@Test
	public void shouldThrowIAEForPlusPrefixedNumber() {
		catchException(phone).setNumber(null);
		
		assertTrue(caughtException() instanceof IllegalArgumentException);
		assertEquals("plus sign prefix no allowed, number: [+123]", caughtException().getMessage());
	}

}
