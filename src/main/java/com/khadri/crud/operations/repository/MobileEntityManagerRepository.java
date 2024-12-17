package com.khadri.crud.operations.repository;

import com.khadri.crud.operations.entity.MobileEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class MobileEntityManagerRepository {

	private EntityManagerFactory entityManagerFactory;

	public MobileEntityManagerRepository(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public void insertMobile(MobileEntity mobile) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(mobile);
		entityManager.getTransaction().commit();
	}

	public MobileEntity updateMobile(MobileEntity mobile) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		MobileEntity updateMobile = entityManager.merge(mobile);
		entityManager.getTransaction().commit();
		return updateMobile;
	}

	public MobileEntity selectMobile(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		MobileEntity findMobile = entityManager.find(MobileEntity.class, id);
		entityManager.getTransaction().commit();

		return findMobile;
	}

	public void deleteMobile(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		MobileEntity removeMobile = entityManager.find(MobileEntity.class, id);
		entityManager.remove(removeMobile);
		entityManager.getTransaction().commit();
	}

	
	}

