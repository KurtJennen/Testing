package chapter00;

public class QuestException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;
	
	public QuestException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
