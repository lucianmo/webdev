package com.serie4it.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serie4it.sample.repository.EmployeeDAO;
import com.serie4it.sample.domain.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
   private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
   
	EmployeeDAO employeeDAO;

	@Autowired(required=true)
	@Qualifier(value="employeeDAO")
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
	   this.employeeDAO = employeeDAO;
	}
	  
	@Override
	@Transactional
	public void persistEmployee(Employee employee) {	   
		employeeDAO.persistEmployee(employee);
		
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
	   logger.info("Employee updated successfully, Employee Details="+employee);
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

	public EmployeeDAO getEmployeeDAO() {
	   return this.employeeDAO;
	}
		   
}
