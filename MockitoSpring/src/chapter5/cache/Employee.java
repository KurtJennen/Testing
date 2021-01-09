package chapter5.cache;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String firstName, lastName, empId;
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmpId() {
		return empId;
	}

	public Employee(String empId, String fName, String lName) {
		this.firstName = fName;
		this.lastName = lName;
		this.empId = empId;
	}

}
