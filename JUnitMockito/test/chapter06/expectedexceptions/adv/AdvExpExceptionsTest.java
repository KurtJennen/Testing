package chapter06.expectedexceptions.adv;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Test;

public class AdvExpExceptionsTest {

	@Test
	public void shouldThrowExceptions() throws InvalidRequestException {
		Request request = createInvalidRequest();
		RequestProcessor requestProcessor = mock(RequestProcessor.class);
		
		RequestHandler sut = new RequestHandler(requestProcessor);
		
		catchException(sut).handle(request);
		
		assertTrue("Should have thrown exception of InvalidRequestException class", caughtException() instanceof InvalidRequestException);
		
		verifyZeroInteractions(requestProcessor);
	}

	private Request createInvalidRequest() {
		return null;
	}
	
	
}
