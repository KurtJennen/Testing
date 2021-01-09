package chapter07.howmanyasserts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddressParsingManyAssertsTest {

	@Test
	public void testAddressParsing() {
		Address anAddress = new Address("ADDR1$CITY IL 60563$COUNTRY");
		
		assertEquals("ADDR1", anAddress.getAddr1());
		assertEquals("CITY IL 60563", anAddress.getCsp());
		assertEquals("COUNTRY", anAddress.getCountry());
	}
	
}
