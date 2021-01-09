package chapter05.mockornot;

public class Phone {
	private final boolean mobile;
	@SuppressWarnings("unused")
	private final String number;
	
	public Phone(String number) {
		this.number = number;
		this.mobile = number.startsWith("+") && number.endsWith("9");
	}
	
	public Phone(String number, boolean mobile) {
		this.number = number;
		this.mobile = mobile;
	}
	
	public boolean isMobile() {
		return mobile;
	}

}
