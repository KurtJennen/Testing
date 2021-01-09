package chapter06.assume;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoreTest {

	@Test
	public void shouldBeRun() {
		System.out.println("shouldBeRun() is running!");
	}
	
	@Test
	@Ignore
	public void shouldBeIgnored() {
		System.out.println("huh, not ignored?!");
	}
	
}
