package chapter06.threadsafe;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class SystemIdGeneratorTest {

	private IdGenerator idGen = new SystemIdGenerator();
	
	@Test
	public void idsShouldBeUnique() {
		Long idA = idGen.nextId();
		Long idB = idGen.nextId();
		
		assertNotEquals("idA " + idA + " idB " + idB, idA, idB);
	}
	
}
