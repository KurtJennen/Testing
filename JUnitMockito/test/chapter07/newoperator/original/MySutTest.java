package chapter07.newoperator.original;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import chapter07.newoperator.MyCollaborator;

public class MySutTest {
	
	@SuppressWarnings("unused")
	@Test
	public void testMyMethod() {
		MySut sut = new MySut();
		MyCollaborator collaborator = mock(MyCollaborator.class);
		
	}

}
