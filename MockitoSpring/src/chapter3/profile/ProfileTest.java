package chapter3.profile;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:chapter3/profile/applicationContext.xml")
//@ActiveProfiles(profiles={"dev"})
//@ActiveProfiles(profiles={"dev", "prod"})
public class ProfileTest {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void profile() throws Exception {
		assertEquals("I'm a dev bean", context.getBean("message"));
		assertEquals("I'm a free bean", context.getBean("noProfileBean"));
	}
}
