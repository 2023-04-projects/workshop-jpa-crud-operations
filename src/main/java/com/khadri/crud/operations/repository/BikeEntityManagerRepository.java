package com.khadri.crud.operations.repository;

import com.khadri.crud.operations.entity.Bike;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class BikeEntityManagerRepository {
	private EntityManagerFactory entityManagerFactory;

	public BikeEntityManagerRepository(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public void insertBike(Bike bike) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(bike);
		entityManager.getTransaction().commit();

	}

	public Bike updateBike(Bike bike) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Bike updateBike = entityManager.merge(bike);
		entityManager.getTransaction().commit();
		return updateBike;

	}

	public Bike selectBike(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Bike selectBike = entityManager.find(Bike.class, id);
		entityManager.getTransaction().commit();
		return selectBike;
	}

	public void deleteBike(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Bike deleteBike = entityManager.find(Bike.class, id);

		entityManager.remove(deleteBike);

		entityManager.getTransaction().commit();
	}

}
