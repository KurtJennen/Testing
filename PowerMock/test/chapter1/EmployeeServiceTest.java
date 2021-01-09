package chapter1;

import java.lang.reflect.Method;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Employee.class, EmployeeIdGenerator.class, EmployeeService.class})
public class EmployeeServiceTest {

	@Test
	public void shouldReturnTheCountOfEmployeesUsingTheDomainClass() {
		PowerMockito.mockStatic(Employee.class);
		
		PowerMockito.when(Employee.count()).thenReturn(900);
		
		EmployeeService employeeService = new EmployeeService();
		
		Assert.assertEquals(900, employeeService.getEmployeeCount());
	}
	
	@Test
	public void shouldReturnTrueWhenIncrementOf10PercentageIsGivenSuccessfully() {
		PowerMockito.mockStatic(Employee.class);
		
		PowerMockito.doNothing().when(Employee.class);
		Employee.giveIncrementOf(10);
		
		EmployeeService employeeService = new EmployeeService();
		
		Assert.assertTrue(employeeService.giveIncrementToAllEmployeesOf(10));
	}
	
	@Test
	public void shouldReturnFalseWhenIncrementOf10PercentageIsNotGivenSuccessfully() {
		PowerMockito.mockStatic(Employee.class);
		
		PowerMockito.doThrow(new IllegalStateException()).when(Employee.class);
		Employee.giveIncrementOf(10);
		
		EmployeeService employeeService = new EmployeeService();
		
		Assert.assertFalse(employeeService.giveIncrementToAllEmployeesOf(10));
	}
	
	@Test
	@Ignore
	public void shouldCreateNewEmployeeIfEmployeeIsNew() {
		Employee mock = PowerMockito.mock(Employee.class);
		
		PowerMockito.when(mock.isNew()).thenReturn(true);
		
		EmployeeService employeeService = new EmployeeService();
		employeeService.saveEmployee(mock);
		
		Mockito.verify(mock).create();
		Mockito.verify(mock, Mockito.never()).update();
	}
	
	@Test
	public void shouldInvokeGiveIncrementOfMethodOnEmployeeWhileGivingIncrement() {
		PowerMockito.mockStatic(Employee.class);
		
		PowerMockito.doNothing().when(Employee.class);
		Employee.giveIncrementOf(10);
		
		EmployeeService employeeService = new EmployeeService();
		employeeService.giveIncrementToAllEmployeesOf(10);
		
		PowerMockito.verifyStatic();
		Employee.giveIncrementOf(10);
	}
	
	@Test
	public void shouldInvokeIsNewBeforeInvokingCreate() {
		Employee mock = PowerMockito.mock(Employee.class);
		
		EmployeeService employeeService = new EmployeeService();
		employeeService.saveEmployee(mock);
		
		InOrder inOrder = Mockito.inOrder(mock);
		
		inOrder.verify(mock).isNew();
		inOrder.verify(mock).update();
		inOrder.verify(mock, Mockito.never()).create();
	}
	
	@Test
	@Ignore
	public void shouldGenerateEmployeeIdIfEmployeeIsNew() {
		Employee mock = PowerMockito.mock(Employee.class);
		PowerMockito.when(mock.isNew()).thenReturn(true);
		
		PowerMockito.mockStatic(EmployeeIdGenerator.class);
		PowerMockito.when(EmployeeIdGenerator.getNextId()).thenReturn(90);
		
		EmployeeService employeeService = new EmployeeService();
		employeeService.saveEmployee(mock);
		
		PowerMockito.verifyStatic();
		EmployeeIdGenerator.getNextId();
		Mockito.verify(mock).setEmployeeId(90);
		Mockito.verify(mock).create();
	}
	
	@Test
	public void shouldSendWelcomeEmailToNewEmployees() throws Exception {
		Employee mock = PowerMockito.mock(Employee.class);
		PowerMockito.when(mock.isNew()).thenReturn(true);
		
		PowerMockito.mockStatic(EmployeeIdGenerator.class);
		
		WelcomeEMail welcomeEMailMock = PowerMockito.mock(WelcomeEMail.class);
		
		PowerMockito.whenNew(WelcomeEMail.class)
			.withArguments(mock, "Welcome to Mocking with PowerMock How-to!")
			.thenReturn(welcomeEMailMock);
		
		EmployeeService employeeService = new EmployeeService();
		employeeService.saveEmployee(mock);
		
		PowerMockito.verifyNew(WelcomeEMail.class)
			.withArguments(mock, "Welcome to Mocking with PowerMock How-to!");
		Mockito.verify(welcomeEMailMock).send();
	}
	
//	@Test
//	public void shouldInvokeTheCreateEmployeeMethodWhileSavingANewEmployee() {
//		final EmployeeService spy = PowerMockito.spy(new EmployeeService());
//		
//		final Employee employeeMock = PowerMockito.mock(Employee.class);
//		PowerMockito.when(employeeMock.isNew()).thenReturn(true);
//		
//		PowerMockito.doNothing().when(spy).createEmployee(employeeMock);
//		
//		spy.saveEmployee(employeeMock);
//		
//		Mockito.verify(spy).createEmployee(employeeMock);
//	}
	
	@Test
	public void shouldInvokeThePrivateCreateEmployeeMethodWhileSavingANewEmployee() throws Exception {
		final EmployeeService spy = PowerMockito.spy(new EmployeeService());
		
		final Employee employeeMock = PowerMockito.mock(Employee.class);
		PowerMockito.when(employeeMock.isNew()).thenReturn(true);
		
		PowerMockito.doNothing().when(spy, "createEmployee", employeeMock);
		
		spy.saveEmployee(employeeMock);
		
		PowerMockito.verifyPrivate(spy).invoke("createEmployee", employeeMock);
	}
	
	@Test
	public void shouldInvokeThePrivateCreateEmployeeMethodWithoutSpecifyingMethodName() throws Exception {
		final EmployeeService spy = PowerMockito.spy(new EmployeeService());
		
		final Employee employeeMock = PowerMockito.mock(Employee.class);
		PowerMockito.when(employeeMock.isNew()).thenReturn(true);
		
		final Method createEmployeeMethod = PowerMockito.method(EmployeeService.class, Employee.class);
		
		PowerMockito.doNothing().when(spy, createEmployeeMethod).withArguments(employeeMock);
		
		spy.saveEmployee(employeeMock);
		
		PowerMockito.verifyPrivate(spy).invoke(createEmployeeMethod).withArguments(employeeMock);
	}
}
