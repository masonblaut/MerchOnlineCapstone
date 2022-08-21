package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Product List Object for creating Lists of ProductModel objects.
 * @author Mason Blaut
 * @version 1.0
 */
@XmlRootElement(name="products")
public class ProductList {
	private List<ProductModel> orders = new ArrayList<ProductModel>();
	/**
	 * Returns an empty ProductModel List.
	 * @return List of ProductModel objects.
	 */
	@XmlElement(name="products")
	public List<ProductModel> getOrders()
	{
		return this.orders;
	}
	/**
	 * Sets the contents of a List with given ProductModel List.
	 * @param orders List of ProductModel objects.
	 */
	public void setOrders(List<ProductModel> orders)
	{
		this.orders = orders;
	}
}