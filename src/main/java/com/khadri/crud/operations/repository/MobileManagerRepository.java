package com.khadri.crud.operations.repository;

import com.khadri.crud.operations.entity.Mobile;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class MobileManagerRepository {

	private EntityManagerFactory entityManagerFactory;

	public MobileManagerRepository(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public void insertMobile(Mobile mobile) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(mobile);
		entityManager.getTransaction().commit();
	}

	public Mobile updateMobile(Mobile mobile) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Mobile updateMobile = entityManager.merge(mobile);
		entityManager.getTransaction().commit();
		return updateMobile;
	}

	public Mobile selectMobile(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Mobile findMobile = entityManager.find(Mobile.class, id);
		entityManager.getTransaction().commit();

		return findMobile;
	}

	public void deleteMobile(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Mobile removeMobile = entityManager.find(Mobile.class, id);
		entityManager.remove(removeMobile);
		entityManager.getTransaction().commit();
	}

}
