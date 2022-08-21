package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserAccountEntity;
import com.gcu.data.repository.ProductRepository;
import com.gcu.model.ProductModel;

/**
 * Spring Service for Data Level Product access. Utilizes ProductRepository and JDBCTemplate for processing SQL statements.
 * @author Mason Blaut
 * @version 1.0
 */
@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {

	@Autowired
	private ProductRepository productRepository;
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Constructor with fields
	 * @param productRepository ProductRepository
	 * @param dataSource DataSource defined in application.properties
	 */
	public ProductDataService(ProductRepository productRepository, DataSource dataSource)
	{
		this.productRepository = productRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	/**
	 * Returns all products available in the database table by iterating through the ProductRepository.
	 */
	public List<ProductEntity> findAll() {
		
		List<ProductEntity> products = new ArrayList<ProductEntity>();
		try
		{
			Iterable<ProductEntity> productsIterable = productRepository.findAll();
			
			products = new ArrayList<ProductEntity>();
			productsIterable.forEach(products::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return products;
	}
	/**
	 * Returns a ProductEntity object by looking through all products with a matching id String within a for loop.
	 * @param id String to be searched for within allProducts for loop.
	 * @return ProductEntity to be returned once found.
	 */
	@Override
	public ProductEntity findById(String id) {
		
		List<ProductEntity> products = findAll();
		
		for (ProductEntity entity : products)
		{
			//System.out.println("Security looking at: " + entity.getUsername()+ " " + entity.getPassword());
			if(entity.getId().toString().equals(id))
			{
				return entity;
			}
		}
		return null;
	}
	/**
	 * Attempts to create a new ProductEntity record within the database using the JdbcTemplate and a SQL INSERT statement.
	 * @param t ProductEntity object to be created.
	 * @return boolean: true upon successful record insertion, false otherwise.
	 */
	@Override
	public boolean create(ProductEntity t) {
		
		String sql = "INSERT INTO `products` (`id`, `product_no`, `product_name`, `price`, `quantity`) VALUES (NULL, ?, ?, ?, ?)";
		try
		{
			jdbcTemplateObject.update(sql,
										t.getProductNo(),
										t.getProductName(),
										t.getPrice(),
										t.getQuantity()
									);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * Attempts to update an existing ProductEntity record within the database using the JdbcTemplate and a SQL UPDATE statement.
	 * @param t ProductEntity object to be updated.
	 * @return boolean: true upon successful record update, false otherwise.
	 */
	@Override
	public boolean update(ProductEntity t) {
		
		String sql = "UPDATE `products` SET `product_no` = ?, `product_name` = ?, `price` = ?, `quantity` = ? WHERE `products`.`id` = ?";
		try
		{
			jdbcTemplateObject.update(sql,
										t.getProductNo(),
										t.getProductName(),
										t.getPrice(),
										t.getQuantity(),
										t.getId()
									);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * Attempts to delete an existing ProductEntity record within the database using the JdbcTemplate and a SQL DELETE statement.
	 * @param t ProductEntity object to be deleted.
	 * @return boolean: true upon successful record deletion, false otherwise.
	 */
	@Override
	public boolean delete(ProductEntity t) {
		
		String sql = "DELETE FROM products WHERE `products`.`id` = ?";
		try
		{
			jdbcTemplateObject.update(sql,
										t.getId()
									);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
}
