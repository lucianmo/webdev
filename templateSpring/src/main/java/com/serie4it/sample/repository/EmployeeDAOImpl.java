package com.serie4it.sample.repository;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.serie4it.sample.domain.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

   private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
   	
	private SessionFactory sessionFactory;

	@Autowired(required=true)
	@Qualifier(value="sessionFactory")
	public void setSessionFactory(SessionFactory sf) {
      this.sessionFactory = sf;
   }

   @Override
	public void persistEmployee(Employee employee) {
      logger.info("Employee saved successfully, Employee Details="+employee);
		sessionFactory.getCurrentSession().persist(employee);
	}

	@Override
	public Employee findEmployeeById(String id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);

	}
	@Override
	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);

	}

}