package chapter06.threadsafe;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;

public class AtomicIdGeneratorTest {
	
	@Rule
	public ConcurrentRule concurrently = new ConcurrentRule();
	@Rule
	public RepeatingRule repeatedly = new RepeatingRule();

	private IdGenerator idGen = new AtomicIdGenerator();
	private Set<Long> ids = new HashSet<Long>(100);
	
//	@Test
//	public void idsShouldBeUnique() {
//		Long idA = idGen.nextId();
//		Long idB = idGen.nextId();
//		
//		assertNotEquals("idA " + idA + " idB " + idB, idA, idB);
//	}
	
	@Test
	@Concurrent(count = 7)
	@Repeating(repetition = 100)
	public void idsShouldBeUnique() {
		assertTrue(ids.add(idGen.nextId()));
	}
	
}
