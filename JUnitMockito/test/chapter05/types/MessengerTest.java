package chapter05.types;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class MessengerTest {
	
	private static final String CLIENT_EMAIL = "some@email.com";
	private static final String MSG_CONTENT = "Dear John! You are fired";

	@Test
	public void shouldSendMail() {
		Template template = mock(Template.class); //dummy
		Client client = mock(Client.class); //stub
		TemplateEngine templateEngine = mock(TemplateEngine.class); //stub
		MailServer mailServer = mock(MailServer.class); //spy
		
		Messenger sut = new Messenger(mailServer, templateEngine);
		
		when(client.getEmail()).thenReturn(CLIENT_EMAIL);
		when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);
		
		sut.sendMessage(client, template);
		
		verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
	}

}
