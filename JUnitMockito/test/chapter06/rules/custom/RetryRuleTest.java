package chapter06.rules.custom;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class RetryRuleTest {
	@Rule
	public RetryTestRule retryTestRule = new RetryTestRule();
	
	static int executionNumber = 0;
	
	@Test
	public void shouldBeRerun() {
		executionNumber++;
		System.out.println("execution: " + executionNumber);
		Assert.fail("failing: " + executionNumber);
	}

}
