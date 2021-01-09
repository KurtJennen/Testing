package chapter06.collections;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;

public class SetEqualityTest {

	private Set<String> setA, setB;
	private String s1, s2;
	
	@Before
	public void setUp() {
		setA = new LinkedHashSet<String>();
		setB = new LinkedHashSet<String>();
		
		s1 = "s1";
		s2 = "s2";
		
		setA.add(s1);
		setA.add(s2);
		
		setB.add(s2);
		setB.add(s1);
	}
	
	@Test
	public void twoSetsAreEqualsIfTheyHaveSameContentAndSameOrder() {
		assertReflectionEquals(setA, setB);
	}
	
	@Test
	public void twoSetsAreEqualsIfTheyHaveSameContentAndAnyOrder() {
		assertReflectionEquals(setA, setB, ReflectionComparatorMode.LENIENT_ORDER);
	}
}
