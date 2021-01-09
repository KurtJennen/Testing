package chapter07.newoperator.refactored;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import chapter07.newoperator.MyCollaborator;

public class MySutRefactoredTest {
	
	private MyCollaborator collaborator;
	
	class MyRefactoredSutSubclassed extends MyRefactoredSut {
		@Override
		protected MyCollaborator createCollaborator() {
			return collaborator;
		}
	}
	
	@Test
	public void testMyMethod() {
		MyRefactoredSut sut = new MyRefactoredSutSubclassed();
		collaborator = mock(MyCollaborator.class);
		
		when(collaborator.someMethod()).thenReturn(true);
		assertTrue(sut.myMethod());
	}
	
}
