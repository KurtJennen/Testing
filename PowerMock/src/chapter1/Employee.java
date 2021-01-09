package chapter1;

public class Employee {
	private int employeeId;
	private String email;
	private long salary;
	
	public Employee() {
	}
	
	public Employee(String email) {
		this.email = email;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public static int count() {
		throw new UnsupportedOperationException();
	}
	
	public static void giveIncrementOf(int percentage) {
		throw new UnsupportedOperationException();
	}
	
	public void save() {
		throw new UnsupportedOperationException();
	}
	
	public boolean isNew() {
		throw new UnsupportedOperationException();
	}
	
	public boolean update() {
		throw new UnsupportedOperationException();
	}
	
	public boolean create() {
		throw new UnsupportedOperationException();
	}
}
