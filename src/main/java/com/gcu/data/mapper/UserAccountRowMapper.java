package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.UserAccountEntity;

public class UserAccountRowMapper implements RowMapper<UserAccountEntity> {
	
	@Override
	public UserAccountEntity mapRow(ResultSet rs, int rowNumber) throws SQLException
	{
		return new UserAccountEntity(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("phone"), rs.getString("address1"), rs.getString("address2"), rs.getString("city"), rs.getString("state"), rs.getString("zip"));
	}
}
