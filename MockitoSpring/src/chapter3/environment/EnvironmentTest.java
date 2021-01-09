package chapter3.environment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=MyConfig.class)
@ContextConfiguration(classes=MyConfig.class, initializers=EnvironmentTest.MockPropertyInitializer.class)
public class EnvironmentTest {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void environment() throws Exception {
//		assertEquals("I'm the king", context.getBean("message"));
//		assertEquals("I'm a mockstar", context.getBean("message"));
		assertEquals("I'm a mock", context.getBean("message"));
	}
	
	public static class MockPropertyInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
//			MockEnvironment mock = new MockEnvironment();
//			mock.setProperty("message", "I'm a mockstar");
//			applicationContext.setEnvironment(mock);
			
			MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();
			MockPropertySource mockEnvVars = new MockPropertySource().withProperty("message", "I'm a mock");
			propertySources.replace(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, mockEnvVars);
			
		}
	}
}
