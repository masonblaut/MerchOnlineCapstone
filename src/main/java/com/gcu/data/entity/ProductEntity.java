package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Product Entity Object used for Data Level operations.
 * @author Mason Blaut
 * @version 1.0
 */
@Table("products")
public class ProductEntity {
	
	@Id
	private Long id;
	
	@Column("product_no")
	private String productNo;
	
	@Column("product_name")
	private String productName;
	
	@Column("price")
	private float price;
	
	@Column("quantity")
	private int quantity;
	/**
	 * Constructor with fields.
	 * @param id Long
	 * @param productNo String
	 * @param productName String
	 * @param price float
	 * @param quantity int
	 */
	public ProductEntity(Long id, String productNo, String productName, float price, int quantity) {
		super();
		this.id = id;
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
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
	public void setProductNo(String productNo) {
		this.productNo = productNo;
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
