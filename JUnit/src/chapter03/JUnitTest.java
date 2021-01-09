package chapter03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void testAdd() {
		String str = "JUnit is working fine";
		assertEquals("JUnit is working fine", str);
	}
	
}
