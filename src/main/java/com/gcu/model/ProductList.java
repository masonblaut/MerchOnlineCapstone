package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="products")
public class ProductList {
	private List<ProductModel> orders = new ArrayList<ProductModel>();
	
	@XmlElement(name="products")
	public List<ProductModel> getOrders()
	{
		return this.orders;
	}
	
	public void setOrders(List<ProductModel> orders)
	{
		this.orders = orders;
	}
}