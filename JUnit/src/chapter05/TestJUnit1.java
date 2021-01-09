package chapter05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestJUnit1 {

	@SuppressWarnings("unused")
	@Test
	public void testAdd() {
		int num = 5;
		String temp = null;
		String str = "JUnit is working fine";
		
		assertEquals("JUnit is working fine",  str);
		
		assertFalse(num > 6);
		
		assertNotNull(str);
	}
	
}
