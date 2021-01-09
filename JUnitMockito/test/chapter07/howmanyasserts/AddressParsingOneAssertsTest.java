package chapter07.howmanyasserts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddressParsingOneAssertsTest {

	private Address anAddress = new Address("ADDR1$CITY IL 60563$COUNTRY");
		
	@Test
	public void testAddr1() {
		assertEquals("ADDR1", anAddress.getAddr1());
	}
	
	@Test
	public void testCsp() {
		assertEquals("CITY IL 60563", anAddress.getCsp());
	}
	
	@Test
	public void testCountry() {
		assertEquals("COUNTRY", anAddress.getCountry());
	}
	
}
