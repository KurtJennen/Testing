package chapter07.random;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class UserToPersonConverterDataProvidersTest {

	@SuppressWarnings({ "deprecation", "unused" })
	private static Object[] getRandomNames() {
		Object[] values = new Object[100];
		
		for (int i = 0; i < values.length; i++) {
			values[i] = $( RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(12));
		}
		
		return values;
	}
	
	@Test
	@Parameters(method = "getRandomNames")
	public void shouldConvertUserNamesIntoPersonNick(String name, String surname) {
		User user = new User(name, surname);
		
		Person person = UserToPersonConverter.convert(user);
		
		assertEquals(name + " " + surname, person.getNick());
	}
}
