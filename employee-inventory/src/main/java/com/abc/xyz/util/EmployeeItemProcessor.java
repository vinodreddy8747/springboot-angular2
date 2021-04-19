package com.abc.xyz.util;

import org.springframework.batch.item.ItemProcessor;

import com.abc.xyz.model.Employee;

public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(final Employee emp) {
		final String name = emp.getName();
		final int age = emp.getAge();

		final Employee processedEmployee = new Employee();
		processedEmployee.setName(name);
		processedEmployee.setAge(age);
		return processedEmployee;
	}
}