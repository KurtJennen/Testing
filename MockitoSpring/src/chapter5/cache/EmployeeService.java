package chapter5.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private final Map<String, Employee> employees = new ConcurrentHashMap<String, Employee>();
	
	@PostConstruct
	public void init() {
		saveEmployee(new Employee("101", "John", "Doe"));
		saveEmployee(new Employee("102", "Jack", "Russell"));
	}

	@CacheEvict(value = "employee", key = "#emp.empId")
	public void saveEmployee(final Employee employee) {
		System.out.println(String.format("Saving a emp with id of : %s", employee.getEmpId()));
		employees.put(employee.getEmpId(), employee);
	}
	
	@Cacheable("employee")
	public Employee getEmployee(final String employeeId) {
		System.out.println(String.format("Loading a employee with id of : %s", employeeId));
		return employees.get(employeeId);
	}
	
}
