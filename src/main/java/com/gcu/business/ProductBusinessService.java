package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

public class ProductBusinessService implements ProductBusinessInterface<ProductModel> {
	
	@Autowired
	ProductDataService service;

	public void test()
	{
		System.out.println("OrdersBusinessService Test!!!");
	}

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
	
	public void init()
	{
		System.out.println("Init");
	}

	public void destroy()
	{
		System.out.println("Destroy");
	}
	
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
}
