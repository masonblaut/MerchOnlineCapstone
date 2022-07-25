package com.gcu.model;

public class ProductModel {


	private Long id;
	private String productNo;
	private String productName;
	private float price;
	private int quantity;
	
	public ProductModel() 
	{
		this.id = null;
	}
	
	public ProductModel(Long id, String productNo, String productName, float price, int quantity)
	{
		this.setId(id);
		this.setProductNo(productNo);
		this.setProductName(productName);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String orderNo) {
		this.productNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
