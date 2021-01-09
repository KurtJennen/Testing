package chapter05;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class TestJUnit2 extends TestCase {
	protected double fValue1;
	protected double fValue2;

	@Before
	protected void start() {
		fValue1 = 2.0;
		fValue2 = 3.0;
	}

	@Test
	public void testAdd() {
		System.out.println("No of Test Case = " + this.countTestCases());
		
		String name = this.getName();
		System.out.println("Test Case Name = " + name);
		
		this.setName("testNewAdd");
		String newName = this.getName();
		System.out.println("Updated Test Case Name = " + newName);
	}
	
}
