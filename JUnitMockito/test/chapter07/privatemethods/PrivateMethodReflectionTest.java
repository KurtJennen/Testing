package chapter07.privatemethods;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class PrivateMethodReflectionTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testingPrivateMethodWithReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		SomeClass sut = new SomeClass();
		
		Class<Long>[] parameterTypes = new Class[1];
		parameterTypes[0] = java.lang.Long.class;
		
		Method m = sut.getClass().getDeclaredMethod("privateMethod", parameterTypes);
		m.setAccessible(true);
		
		Object[] parameters = new Object[1];
		parameters[0] = 5569L;
		
		Boolean result = (Boolean) m.invoke(sut, parameters);
		
		assertTrue(result);
	}
	
}
