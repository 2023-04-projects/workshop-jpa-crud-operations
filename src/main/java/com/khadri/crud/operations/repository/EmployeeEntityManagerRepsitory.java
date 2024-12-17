package com.khadri.crud.operations.repository;

import com.khadri.crud.operations.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EmployeeEntityManagerRepsitory {

	private EntityManagerFactory entityManagerFactory;

	public EmployeeEntityManagerRepsitory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public void insertEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

	public Employee updateEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee updatedEmployee = entityManager.merge(employee);
		entityManager.getTransaction().commit();
		return updatedEmployee;
	}

	public Employee selectEmployee(Integer empId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee updatedEmployee = entityManager.find(Employee.class, empId);
		entityManager.getTransaction().commit();
		return updatedEmployee;
	}

	public void deleteEmployee(Integer empId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee emp=entityManager.find(Employee.class, empId);
		if(emp!=null){
			entityManager.remove(emp);
			
		}

		entityManager.getTransaction().commit();
	}

}
