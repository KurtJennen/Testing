package chapter3.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:chapter3/listener/applicationContext.xml")
@TestExecutionListeners({SysOutTestExecutionListener.class})
public class TestExecutionListenerTest {

	@Test
	public void someTest() {
		System.out.println("executing someTest");
	}
	
	@Test
	public void someOtherTest() {
		System.out.println("executing someOtherTest");
	}
	
}
