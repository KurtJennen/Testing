package chapter07.setup;

import static org.mockito.Mockito.mock;

import org.junit.Test;

public class EachMethodTest {
	
	@Test
	public void testA() {
		Collaborator collaborator = mock(Collaborator.class);
		OtherCollaborator otherCollaborator = mock(OtherCollaborator.class);
		SUT sut = new SUT(collaborator, otherCollaborator);
		
		sut.someMethod();
	}
	
	@Test
	public void testB() {
		Collaborator collaborator = mock(Collaborator.class);
		OtherCollaborator otherCollaborator = mock(OtherCollaborator.class);
		SUT sut = new SUT(collaborator, otherCollaborator);
		
		sut.otherMethod();
	}

}
