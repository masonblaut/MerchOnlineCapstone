package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.ProductEntity;

/**
 * RowMapper implementation for ProductEntity objects.
 * @author Mason Blaut
 * @version 1.0
 */
public class ProductRowMapper implements RowMapper<ProductEntity> {
	/**
	 * Maps the specified row names with the ProductEntity constructor fields.
	 * @return ProductEntity 
	 */
	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNumber) throws SQLException
	{
		return new ProductEntity(rs.getLong("id"), rs.getString("product_no"), rs.getString("product_name"), rs.getFloat("price"), rs.getInt("quantity"));
	}
}
