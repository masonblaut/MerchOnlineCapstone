package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductModel;



public interface ProductBusinessInterface<T> {

public void init();
	
	public void destroy();
	
	public void test();

	public List<ProductModel> getProducts();
	
	public boolean create(T t);
}
