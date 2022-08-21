package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserAccountEntity;
import com.gcu.model.ProductModel;

/**
 * Main Product Business layer Service that implements ProductBusinessInterface with a type of ProductModel.
 * @author Mason Blaut
 * @version 1.0
 *
 */
public class ProductBusinessService implements ProductBusinessInterface<ProductModel> {
	
	@Autowired
	ProductDataService service;

	/*
	 * Service Test Method
	 */
	public void test()
	{
		System.out.println("OrdersBusinessService Test!!!");
	}
	/**
	 * Service Initialization Method
	 */
	public void init()
	{
		System.out.println("Init");
	}
	/**
	 * Service Destroy Method
	 */
	public void destroy()
	{
		System.out.println("Destroy");
	}
	/**
	 * Gets a List of all ProductModel objects.
	 */
	public List<ProductModel> getProducts() {
		List<ProductEntity> entities = service.findAll();
		
		List<ProductModel> products = new ArrayList<ProductModel>();
		
		for (ProductEntity entity : entities)
		{
			ProductModel addProd = new ProductModel(entity.getId(), entity.getProductNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity());
			products.add(addProd);
		}	
		
		return products;
	}
	/**
	 * Returns a single ProductModel Object found with the id String by the ProductDataService.
	 * @param id ProductModel's id String
	 * @return ProductModel to be sent to the view controller.
	 */
	public ProductModel findProductById(String id)
	{
		ProductEntity entity = service.findById(id);
		
		if(entity != null)
		{
			return new ProductModel(entity.getId(), entity.getProductNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity());
		}
		else
			return null;
	}
	/**
	 * Updates a ProductModel by calling update() from the ProductDataService. Returns a boolean upon completion.
	 * @param product ProductModel with updated values.
	 * @return boolean; true if the ProductModel was able to be edited and false if the operation from the data service failed.
	 */
	public boolean updateProduct(ProductModel product)
	{
		ProductEntity entity = new ProductEntity(product.getId(), product.getProductNo(), product.getProductName(), product.getPrice(), product.getQuantity());
		
		if (service.update(entity))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Creates a new ProductModel by calling create() from the ProductDataService.
	 * @param product ProductModel object to be created.
	 * @return boolean: true for successful object creation in data service and false for failed creation.
	 */
	public boolean create(ProductModel product) 
	{
		ProductEntity entity = new ProductEntity(product.getId(), product.getProductNo(), product.getProductName(), product.getPrice(), product.getQuantity());
		
		if (service.create(entity))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Deletes a ProductModel from the Data Service and calls delete() from the Data Service.
	 * @param product ProductModel object to be deleted.
	 * @return boolean: true for successful object deletion and false for failed object deletion from Data Service.
	 */
	public boolean deleteProduct(ProductModel product) {
		ProductEntity entity = new ProductEntity(product.getId(), product.getProductNo(), product.getProductName(), product.getPrice(), product.getQuantity());
		
		if (service.delete(entity))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
