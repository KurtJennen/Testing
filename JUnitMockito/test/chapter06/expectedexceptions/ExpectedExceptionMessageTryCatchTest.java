package chapter06.expectedexceptions;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpectedExceptionMessageTryCatchTest {
	Phone phone = new Phone();

	@Test
	public void shouldThrowIAEForEmptyNumber() {
		try {
			phone.setNumber(null);
			fail("Should have thrown IllegalArgumentException");
		} catch (IllegalArgumentException iae) {
			assertEquals("number can not be null or empty", iae.getMessage());
		}
	}
	
	@Test
	public void shouldThrowIAEForPlusPrefixedNumber() {
		try {
			phone.setNumber("+123");
			fail("Should have thrown IllegalArgumentException");
		} catch (IllegalArgumentException iae) {
			assertEquals("plus sign prefix no allowed, number: [+123]", iae.getMessage());
		}
	}

}
