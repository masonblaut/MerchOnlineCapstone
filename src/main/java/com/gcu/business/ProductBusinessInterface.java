package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductModel;


/**
 * Interface for Product Business operations. The Generic T gives flexibility for different kinds of Product Models.
 * @author Mason Blaut
 * @version 1.0
 * @param <T>
 */
public interface ProductBusinessInterface<T> {

	/**
	 * Service Initialization Method
	 */
	public void init();
	/**
	 * Service Destroy Method
	 */
	public void destroy();
	/**
	 * Service Test Method
	 */
	public void test();
	/**
	 * Gets a List of all ProductModel objects.
	 */
	public List<ProductModel> getProducts();
	/**
	 * Returns a single ProductModel Object found by the id String
	 * @param id ProductModel's id String
	 * @return ProductModel to be sent to the view controller.
	 */
	public ProductModel findProductById(String id);
	/**
	 * Updates a ProductModel by passing a ProductModel to the Data Service. Returns a boolean upon completion.
	 * @param product ProductModel with updated values.
	 * @return boolean; true if the ProductModel was able to be edited and false if the operation from the data service failed.
	 */
	public boolean updateProduct(ProductModel product);
	/**
	 * Creates a new Generic Product and pushes it to the Data Service.
	 * @param t Generic, but will most often be used as a ProductModel object.
	 * @return boolean: true for successful object creation in data service and false for failed creation.
	 */
	public boolean create(T t);
	/**
	 * Deletes a Generic from the Data Service and calls the Data Service.
	 * @param t Generic object to be deleted.
	 * @return boolean: true for successful object deletion and false for failed object deletion from Data Service.
	 */
	public boolean deleteProduct(T t);
}
