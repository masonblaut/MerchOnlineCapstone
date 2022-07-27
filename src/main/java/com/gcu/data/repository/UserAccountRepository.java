package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.UserAccountEntity;

public interface UserAccountRepository extends CrudRepository<UserAccountEntity, Long> 
{
	
	@Override
	@Query(value = "SELECT * FROM `user_account`")
	public List<UserAccountEntity> findAll();
	
}
