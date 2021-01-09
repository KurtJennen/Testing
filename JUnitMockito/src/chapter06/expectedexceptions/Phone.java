package chapter06.expectedexceptions;

public class Phone {
	@SuppressWarnings("unused")
	private String number;
	
	public Phone() {
	}

	public void setNumber(String number) {
		if (number == null || number.isEmpty()) {
			throw new IllegalArgumentException("number can not be null or empty");
		}
		if (number.startsWith("+")) {
			throw new IllegalArgumentException("plus sign prefix no allowed, number: [" + number + "]");
		}
		this.number = number;
	}
}
