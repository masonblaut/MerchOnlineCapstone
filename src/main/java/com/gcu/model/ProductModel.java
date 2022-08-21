package com.gcu.model;
/**
 * Product Model Object used for Business Level operations.
 * @author Mason Blaut
 * @version 1.0
 */
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
	/**
	 * Contructor with fields.
	 * @param id Long
	 * @param productNo String
	 * @param productName String
	 * @param price float
	 * @param quantity int
	 */
	public ProductModel(Long id, String productNo, String productName, float price, int quantity)
	{
		this.setId(id);
		this.setProductNo(productNo);
		this.setProductName(productName);
		this.setPrice(price);
		this.setQuantity(quantity);
	}
	/**
	 * getId method
	 * @return id Long
	 */
	public Long getId() {
		return id;
	}
	/**
	 * setId method
	 * @param id Long
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * getProductNo method
	 * @return productNo String
	 */
	public String getProductNo() {
		return productNo;
	}
	/**
	 * setProductNo method
	 * @param productNo String
	 */
	public void setProductNo(String orderNo) {
		this.productNo = orderNo;
	}
	/**
	 * getProductName method
	 * @return productName String
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * setProductName method
	 * @param productName String
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * getPrice method
	 * @return price float
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * setPrice method
	 * @param price float
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * getQuantity method
	 * @return quantity int
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * setQuantity method
	 * @param quantity int
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
