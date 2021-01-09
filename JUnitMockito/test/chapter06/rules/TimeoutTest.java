package chapter06.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutTest {
	
	@SuppressWarnings("deprecation")
	@Rule
	public Timeout globalTimeout = new Timeout(20);
	
	@Test
	public void willFail() throws InterruptedException {
		Thread.sleep(100);
	}
	
	@Test
	public void willPass() throws InterruptedException {
		Thread.sleep(10);
	}

}
