package com.serie4it.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serie4it.sample.repository.EmployeeDAO;
import com.serie4it.sample.domain.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public void persistEmployee(Employee employee) {
		employeeDAO.persistEmployee(employee);
		
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
		
	}
	@Override
	@Transactional
	public Employee findEmployeeById(String id) {
		return employeeDAO.findEmployeeById(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee employee) {
		employeeDAO.deleteEmployee(employee);
		
	}

}
