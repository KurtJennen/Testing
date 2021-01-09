package chapter07.newoperator.partial;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.Test;

import chapter07.newoperator.MyCollaborator;

public class MySutPartialTest {

	@Test
	public void testMyMethod() {
		MyPartialSut sut = spy(new MyPartialSut());
		MyCollaborator collaborator = mock(MyCollaborator.class);
		
		doReturn(collaborator).when(sut).createCollaborator();
		
		when(collaborator.someMethod()).thenReturn(true);
		
		assertTrue(sut.myMethod());
	}
	
}
