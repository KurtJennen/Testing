package chapter1;

public class EmployeeService {
	public int getEmployeeCount() {
		//throw new UnsupportedOperationException();
		return Employee.count();
	}

	public boolean giveIncrementToAllEmployeesOf(int percentage) {
		try {
			Employee.giveIncrementOf(percentage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void saveEmployee(Employee employee) {
		if(employee.isNew()) {
//			employee.setEmployeeId(EmployeeIdGenerator.getNextId());
//			employee.create();
//			WelcomeEMail emailSender = new WelcomeEMail(employee, "Welcome to Mocking with PowerMock How-to!");
//			emailSender.send();
			createEmployee(employee);
			return;
		}
		employee.update();
	}

	private void createEmployee(Employee employee) {
		employee.setEmployeeId(EmployeeIdGenerator.getNextId());
		employee.create();
		WelcomeEMail emailSender = new WelcomeEMail(employee, "Welcome to Mocking with PowerMock How-to!");
		emailSender.send();
	}

	public Employee findEmployeeByEmail(String email) {
		throw new UnsupportedOperationException();
	}

	public boolean employeeExists(Employee employee) {
		throw new UnsupportedOperationException();
	}
}
