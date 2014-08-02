package com.serie4it.sample.repository;

import com.serie4it.sample.domain.Employee;

public interface EmployeeDAO {
	
		  void persistEmployee(Employee employee);
		  
		  Employee findEmployeeById(String id);
		  
		  void updateEmployee(Employee employee);
		  
		  void deleteEmployee(Employee employee);
		  
}
