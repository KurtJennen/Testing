package chapter06.collections.fest;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import chapter06.collections.Book;

public class FestCollectionTest {

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
	public void collectionsUtilityMethods() {
		assertThat(setA).isNotEmpty().hasSize(2).doesNotHaveDuplicates();
		assertThat(setA).containsOnly(s1, s2);
	}
	
	@Test
	public void mapUtilityMethods() {
		HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("a", 2);
		map.put("b", 3);
		
		assertThat(map).isNotNull().isNotEmpty().includes(entry("a", 2), entry("b", 3)).excludes(entry("c", 1));
	}
	
	@Test
	public void lookingIntoProperties() {
		Collection<Book> books = new HashSet<Book>();
		books.add(new Book("Homer",  "Odyssey"));
		books.add(new Book("J.R.R. Tolkien",  "Hobbit"));
		
		assertThat(books).onProperty("title").contains("Hobbit");
		assertThat(books).onProperty("author").contains("J.R.R. Tolkien");
		assertThat(books).onProperty("author").contains("J.K. Rowling");
	}
}
