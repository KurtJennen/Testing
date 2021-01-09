package chapter07.newoperator.injection.method;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import chapter07.newoperator.MyCollaborator;

public class MySutTest {

	@Test
	public void testMyMethod() {
		MySut sut = new MySut();
		MyCollaborator collaborator = mock(MyCollaborator.class);

		sut.myMethod(collaborator);

	}
	
}
