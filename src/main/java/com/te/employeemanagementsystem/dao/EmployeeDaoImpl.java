package com.te.employeemanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.employeemanagementsystem.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	public boolean registerDao(Employee employee) {
		boolean isRegistered = false;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			System.out.println(employee);
			manager.merge(employee);
			transaction.commit();
			isRegistered = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return isRegistered;
	}

}
