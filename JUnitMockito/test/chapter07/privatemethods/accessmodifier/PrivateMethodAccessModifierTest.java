package chapter07.privatemethods.accessmodifier;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrivateMethodAccessModifierTest {

	@Test
	public void testingPrivateMethodWithReflection() throws Exception {
		SomeClass sut = new SomeClass();
		
		assertTrue(sut.privateMethod(9238423L));
	}
	
}
