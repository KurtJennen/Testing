package chapter06.collections.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class HamcrestCollectionTest {

	private Set<String> setA, setB;
	private String s1, s2;
	
	private Map<String, Object> map;
	
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
		
		map = new LinkedHashMap<String, Object>();
	}
	
	@Test
	public void collectionsUtilityMethods() {
		assertThat(setA, hasItem(s1));
		assertThat(setA, hasItem(s2));
		assertThat(setA, hasItem("xyz"));
		assertThat(setA, hasItems(s1, s2, "xyz"));
	}
	
	@Test
	public void mapUtilityMethods() {
		assertThat(map, hasEntry("a", (Object) 2));
		assertThat(map, hasKey("b"));
	}
	
}
