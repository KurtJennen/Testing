package chapter07.setup;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class SetUpTest {
	
	Collaborator collaborator;
	OtherCollaborator otherCollaborator;
	SUT sut;
	
	@Before
	public void setUp() {
		collaborator = mock(Collaborator.class);
		otherCollaborator = mock(OtherCollaborator.class);
		sut = new SUT(collaborator, otherCollaborator);
	}
	
	@Test
	public void testA() {
		sut.someMethod();
	}
	
	@Test
	public void testB() {
		sut.otherMethod();
	}

}
