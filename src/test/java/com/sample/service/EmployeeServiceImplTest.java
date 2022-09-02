package com.sample.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sample.dao.EmployeeDao;
import com.sample.model.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

	@Mock
	EmployeeDao employeeDao;
	private EmployeeServiceImpl employeeService;

	@Before
	public void setup() {
		employeeService = new EmployeeServiceImpl();
	}
	
	@Test
	public void testEmployeeNotAvailable() {
		org.mockito.Mockito.when(employeeDao.getEmployee(1)).thenReturn(null);
		employeeService.setEmployeeDao(employeeDao);
		Employee employee = employeeService.getEmployee(1);
		
		assertNull(employee);
	}

	@Test
	public void testEmployeeAvailable() {
		employeeService = new EmployeeServiceImpl();
		Employee dummyEmployee = new Employee();
		dummyEmployee.setEmpId(1);
		dummyEmployee.setEmpName("Sandy");
		org.mockito.Mockito.when(employeeDao.getEmployee(1)).thenReturn(dummyEmployee);
		employeeService.setEmployeeDao(employeeDao);
		Employee employee = employeeService.getEmployee(1);
		
		assertEquals("Name didn't matched", "Sandy", employee.getEmpName());
	}
}
