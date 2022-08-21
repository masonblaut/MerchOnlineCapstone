package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.ProductEntity;
/**
 * Product Repository object which extends CrudRepository with types ProductEntity and Long. Used to execute SQL statements which return all Products.
 * @author Mason Blaut
 * @version 1.0
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
	/**
	 * Executes a SELECT * SQL statement from the products table within the database
	 * @return List of ProductEntity objects
	 */
	@Override
	@Query(value = "SELECT * FROM `products`")
	public List<ProductEntity> findAll();
}
