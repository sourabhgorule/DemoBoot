package com.springboot.Service;

import java.util.List;

import com.springboot.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);
	
	List<Employee> getAllemployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee emp,long id);
	
	void deleteEmployee(long id);
}
