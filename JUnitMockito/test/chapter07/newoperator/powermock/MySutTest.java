package chapter07.newoperator.powermock;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import chapter07.newoperator.MyCollaborator;

@PrepareForTest(MySut.class)
@RunWith(PowerMockRunner.class)
public class MySutTest {

	@SuppressWarnings("unused")
	@Test
	public void testMyMethod() throws Exception {
		MySut sut = new MySut();
		MyCollaborator collaborator = mock(MyCollaborator.class);
		
		PowerMockito.whenNew(MyCollaborator.class).withNoArguments().thenReturn(collaborator);
		
	}
}
