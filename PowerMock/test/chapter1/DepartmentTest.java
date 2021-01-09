package chapter1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Department.class)
@SuppressStaticInitializationFor("chapter1.BaseEntity")
public class DepartmentTest {

//	@Test
//	public void shouldVerifyThatNewEmployeeIsAddedToTheDepartment() {
//		final Department department = new Department();
//		final Employee employee = new Employee();
//		
//		department.addEmployee(employee);
//		
//		final List<Employee> employees = (List<Employee>)Whitebox.getInternalState(department, "employees");
//		
//		Assert.assertTrue(employees.contains(employee));
//	}
//	
//	@Test
//	public void shouldAddNewEmployeeToTheDepartment() {
//		final Department department = new Department();
//		final Employee employee = new Employee();
//		
//		final ArrayList<Employee> employees = new ArrayList<Employee>();
//		
//		Whitebox.setInternalState(department, "employees", employees);
//		
//		department.addEmployee(employee);
//		
//		Assert.assertTrue(employees.contains(employee));
//	}
//	
//	@Test
//	public void shouldVerifyThatMaxSalaryOfferedForADepartmentIsCalculatedCorrectly() throws Exception {
//		final Department department = new Department();
//		final Employee employee1 = new Employee();
//		final Employee employee2 = new Employee();
//		employee1.setSalary(60000);
//		employee2.setSalary(65000);
//		
//		final ArrayList<Employee> employees = new ArrayList<Employee>();
//		employees.add(employee1);
//		employees.add(employee2);
//		
//		Whitebox.setInternalState(department, "employees", employees);
//		Whitebox.invokeMethod(department, "updateMaxSalaryOffered");
//		
//		final long maxSalary = Whitebox.getInternalState(department, "maxSalaryOffered");
//		Assert.assertEquals(65000, maxSalary);
//	}
	
	@Test
	public void shouldSuppressTheBaseConstructorOfDepartment() {
		PowerMockito.suppress(PowerMockito.constructor(BaseEntity.class));
		Assert.assertEquals(10, new Department(10).getDepartmentId());
	}
	
	@Test
	public void shouldSuppressThePerformAuditMethodOfBaseEntity() {
		PowerMockito.suppress(PowerMockito.constructor(BaseEntity.class));
		PowerMockito.suppress(PowerMockito.method(BaseEntity.class, "performAudit", String.class));
		final Department department = new Department();
		department.setName("Mocking with PowerMock");
		Assert.assertEquals("Mocking with PowerMock", department.getName());
	}
	
	@Test
	public void shouldSuppressTheInitializerForBaseEntity() {
		PowerMockito.suppress(PowerMockito.constructor(BaseEntity.class));
		Assert.assertNotNull(new Department());
	}
}
