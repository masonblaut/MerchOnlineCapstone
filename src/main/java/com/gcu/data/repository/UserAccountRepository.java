package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.UserAccountEntity;
/**
 * UserAccount Repository object which extends CrudRepository with types UserAccountEntity and Long. Used to execute SQL statements which return all UserAccount objects.
 * @author Mason Blaut
 * @version 1.0
 */
public interface UserAccountRepository extends CrudRepository<UserAccountEntity, Long> 
{
	/**
	 * Executes a SELECT * SQL statement from the user_account table within the database
	 * @return List of UserAccountEntity objects
	 */
	@Override
	@Query(value = "SELECT * FROM `user_account`")
	public List<UserAccountEntity> findAll();
	
}
