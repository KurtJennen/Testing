package chapter10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJUnit1 {

	String message = "Robert";
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Test
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage");
		assertEquals(message, messageUtil.printMessage());
	}
	
}
