package com.khadri.crud.operations.repository;

import com.khadri.crud.operations.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ProductEntityManagerRepsoitory {

	private EntityManagerFactory entityManagerFactory;

	public ProductEntityManagerRepsoitory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public void insertProduct(Product product) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();
	}

	public Product updateProduct(Product product) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Product updatedProduct = entityManager.merge(product);
		entityManager.getTransaction().commit();
		return updatedProduct;
	}

	public Product selectProductById(int prodId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product selectedProduct = entityManager.find(Product.class, prodId);
		return selectedProduct;
	}

	public void deleteProductById(int prodId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Product product = entityManager.find(Product.class, prodId);

		entityManager.remove(product);
		entityManager.getTransaction().commit();
	}
}
