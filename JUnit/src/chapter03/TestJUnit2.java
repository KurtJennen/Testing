package chapter03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJUnit2 {

		String message = "Robert";
		MessageUtil messageUtil = new MessageUtil(message);
		
		@Test
		public void testSalutionMessage() {
			System.out.println("Inside testSalutationMessage");
			message = "Hi!" + "Robert";
			assertEquals(message, messageUtil.salutationMessage());
		}
	
}
