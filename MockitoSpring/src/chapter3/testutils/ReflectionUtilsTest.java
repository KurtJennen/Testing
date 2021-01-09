package chapter3.testutils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;

import org.junit.Test;
import org.springframework.util.ReflectionUtils;


public class ReflectionUtilsTest {

	@Test
	public void private_field_access() throws Exception {
		Secret myClass = new Secret();
		myClass.initiate("aio");
		
		Field secretField = ReflectionUtils.findField(Secret.class, "secret", String.class);
		assertNotNull(secretField);
		
		ReflectionUtils.makeAccessible(secretField);
		assertEquals("zko", ReflectionUtils.getField(secretField, myClass));
		
		ReflectionUtils.setField(secretField, myClass, "cool");
		assertEquals("cool", ReflectionUtils.getField(secretField, myClass));
	}
	
}
