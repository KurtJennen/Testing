package chapter06.matchers;

public class Book {
	private final String title;
	private String language;
	
	public Book(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		Book book = (Book) o;
		
		if (title != null ? !title.equals(book.title) : book.title != null) return false;
		
		return true;
	}
}
