package com.khadri.crud.operations.repository.pharmacy;

import com.khadri.crud.operations.entity.pharmacy.Tablet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class TabletEntityManagerRepsoitory {

	private EntityManagerFactory entityManagerfactory;
	 

	public TabletEntityManagerRepsoitory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerfactory = entityManagerFactory;
	}

	 

	public void insertTablet(Tablet tablet) {
		EntityManager entityManager = entityManagerfactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(tablet);
		entityManager.getTransaction().commit();
	}
	 

	public Tablet updateTablet(Tablet tablet) {
		EntityManager entityManager = entityManagerfactory.createEntityManager();
		entityManager.getTransaction().begin();
		Tablet updatedTablet = entityManager.merge(tablet);
		entityManager.getTransaction().commit();
		return updatedTablet;
	}
	public Tablet viewTablet(Integer viewId ) {
		EntityManager entityManager = entityManagerfactory.createEntityManager();
		return entityManager.find(Tablet.class, viewId);
		
	}
	public void deleteTablet(Integer id) {
	    EntityManager entityManager = entityManagerfactory.createEntityManager();
	    try {
	        entityManager.getTransaction().begin();
	        
	         
	        Tablet removeTablet = entityManager.find(Tablet.class, id);
	        
	       
	        if (removeTablet != null) {
	            entityManager.remove(removeTablet);  
	            System.out.println("Tablet with ID " + id + " deleted.");
	        } else {
	            System.out.println("Tablet with ID " + id + " does not exist.");
	        }
	        entityManager.getTransaction().commit();
	    } catch (RuntimeException e) {
	        if (entityManager.getTransaction().isActive()) {
	            entityManager.getTransaction().rollback();
	        }
	        throw e;  
	    }
	}

}
