package com.serie4it.sample.service;

import com.serie4it.sample.domain.Employee;

public interface EmployeeService {

	void persistEmployee(Employee employee);

	Employee findEmployeeById(String id);

	void updateEmployee(Employee employee);

	void deleteEmployee(Employee employee);
}
