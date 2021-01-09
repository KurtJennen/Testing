package chapter07.setup;

import static org.mockito.Mockito.mock;

import org.junit.Test;

public class DeclarationTest {
	
	Collaborator collaborator = mock(Collaborator.class);
	OtherCollaborator otherCollaborator = mock(OtherCollaborator.class);
	SUT sut = new SUT(collaborator, otherCollaborator);
	
	@Test
	public void testA() {
		sut.someMethod();
	}
	
	@Test
	public void testB() {
		sut.otherMethod();
	}

}
