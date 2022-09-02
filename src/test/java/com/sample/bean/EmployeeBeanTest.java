package com.sample.bean;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeBeanTest {

	@Test
	public void testGetterSetter() {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setName("name");
		assertEquals("Setter not returning right name", "name", employeeBean.getName());
	}

}
