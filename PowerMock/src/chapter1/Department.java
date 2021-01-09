package chapter1;

import java.util.ArrayList;
import java.util.List;

//public class Department { 
public class Department extends BaseEntity {
	private List<Employee> employees = new ArrayList<Employee>();
	
	private long maxSalaryOffered;
	
	private int departmentId;
	private String name;
	
	public Department() {
		super();
	}
	
	public Department(int departmentId) {
		super();
		this.departmentId = departmentId;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		super.performAudit(this.name);
	}

	public void addEmployee(final Employee employee) {
		employees.add(employee);
		updateMaxSalaryOffered();
	}
	
	private void updateMaxSalaryOffered() {
		maxSalaryOffered = 0;
		for (Employee employee : employees) {
			if (employee.getSalary() > maxSalaryOffered) {
				maxSalaryOffered = employee.getSalary();
			}
		}
	}
}
