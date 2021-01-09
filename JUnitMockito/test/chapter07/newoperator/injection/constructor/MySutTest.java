package chapter07.newoperator.injection.constructor;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import chapter07.newoperator.MyCollaborator;

public class MySutTest {

	@SuppressWarnings("unused")
	@Test
	public void testMyMethod() {
		MyCollaborator collaborator = mock(MyCollaborator.class);
		MySut sut = new MySut(collaborator);
		
	}
	
}
