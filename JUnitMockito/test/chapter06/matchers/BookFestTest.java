package chapter06.matchers;

import static chapter06.matchers.BookAssert.assertThat;

import org.junit.Test;

public class BookFestTest {
	private static final String TITLE = "My book";
	
	@Test
	public void constructorShoudSetTitle() {
		Book book = new Book(TITLE);
		
		assertThat(book).hasTitle(TITLE);
	}
}
