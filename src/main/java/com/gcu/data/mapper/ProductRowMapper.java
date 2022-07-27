package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.ProductEntity;


public class ProductRowMapper implements RowMapper<ProductEntity> {

	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNumber) throws SQLException
	{
		return new ProductEntity(rs.getLong("id"), rs.getString("product_no"), rs.getString("product_name"), rs.getFloat("price"), rs.getInt("quantity"));
	}
}
