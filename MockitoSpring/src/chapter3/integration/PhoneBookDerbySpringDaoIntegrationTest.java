package chapter3.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import chapter1.PhoneBookDao;
import chapter1.PhoneBookMySqlSpringDao;
import chapter1.PhoneEntry;

@ContextConfiguration({"classpath:integration.xml"})
@TransactionConfiguration(transactionManager = "transactionManagerBean", defaultRollback = true)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class PhoneBookDerbySpringDaoIntegrationTest {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	PhoneBookDao dao;
	
	@Before
	public void init() {
		dao = new PhoneBookMySqlSpringDao(jdbcTemplate);
	}
	
	@Test
	public void integration() throws Exception {
		PhoneEntry entry = new PhoneEntry();
		entry.setPhoneNumber("12345");
		entry.setFirstName("Mark");
		entry.setLastName("Smith");
		
		assertTrue(dao.create(entry));
		
//		List<PhoneEntry> phoneEntries = dao.searchByFirstName("Mark");
//		assertFalse(phoneEntries.isEmpty());
//		
//		entry.setLastName("Boucher");
//		
//		assertTrue(dao.update(entry));
//		
//		phoneEntries = dao.searchByFirstName("Mark");
//		
//		assertFalse(phoneEntries.isEmpty());
//		assertEquals("Boucher", phoneEntries.get(0).getLastName());
//		
//		dao.delete(entry.getPhoneNumber());
//		
//		phoneEntries = dao.searchByFirstName("Mark");
//		
//		assertTrue(phoneEntries.isEmpty());
	}
	
}
