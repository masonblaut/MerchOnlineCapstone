package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.ProductModel;

public class ProductsBusinessService implements ProductsBusinessInterface {

	public void test()
	{
		System.out.println("OrdersBusinessService Test!!!");
	}

	public List<ProductModel> getProducts() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		products.add(new ProductModel(0L, "0000000001", "Product 1", 1.00f, 1));
		products.add(new ProductModel(1L, "0000000002", "Product 2", 2.00f, 2));
		products.add(new ProductModel(2L, "0000000003", "Product 3", 3.00f, 3));
		products.add(new ProductModel(3L, "0000000004", "Product 4", 4.00f, 4));
		products.add(new ProductModel(4L, "0000000005", "Product 5", 5.00f, 5));
		
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
}
