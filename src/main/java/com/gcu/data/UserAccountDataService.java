package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserAccountEntity;
import com.gcu.data.repository.UserAccountRepository;

/**
 * Spring Service for Data Level UserAccount access. Utilizes UserAccountRepository and JDBCTemplate for processing SQL statements.
 * @author Mason Blaut
 * @version 1.0
 */
@Service
public class UserAccountDataService implements DataAccessInterface<UserAccountEntity> 
{

	@Autowired
	private UserAccountRepository userAccountRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	/**
	 * Constructor with fields
	 * @param productRepository ProductRepository
	 * @param dataSource DataSource defined in application.properties
	 */
	public UserAccountDataService(UserAccountRepository userAccountRepository, DataSource dataSource)
	{
		this.userAccountRepository = userAccountRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public UserAccountEntity findById(String id)
	{
		return null;
	}
	/**
	 * Returns all user accounts available in the database table by iterating through the ProductRepository.
	 */
	public List<UserAccountEntity> findAll()
	{
		List<UserAccountEntity> accounts = new ArrayList<UserAccountEntity>();
		try
		{
			Iterable<UserAccountEntity> accountsIterable = userAccountRepository.findAll();
			
			accounts = new ArrayList<UserAccountEntity>();
			accountsIterable.forEach(accounts::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return accounts;
	}
	/**
	 * Attempts to create a new UserAccountEntity record within the database using the JdbcTemplate and a SQL INSERT statement.
	 * @param t UserAccountEntity object to be created.
	 * @return boolean: true upon successful record insertion, false otherwise.
	 */
	public boolean create(UserAccountEntity user)
	{
		String sql = "INSERT INTO `user_account` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `phone`, `address1`, `address2`, `city`, `state`, `zip`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try
		{
			jdbcTemplateObject.update(sql,
										user.getUserFirstName(),
										user.getUserLastName(),
										user.getUserEmail(),
										user.getUsername(),
										user.getPassword(),
										user.getUserPhoneNum(),
										user.getUserAddress1(),
										user.getUserAddress2(),
										user.getUserCity(),
										user.getUserState(),
										user.getUserZip()
									);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UserAccountEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserAccountEntity t) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Returns a UserAccountEntity object by looking through all accounts with a matching username String within a for loop.
	 * @param username String to be searched for within allProducts for loop.
	 * @return UserAccountEntity to be returned once found.
	 */
	public UserAccountEntity findByUsername(String username) {
		
		List<UserAccountEntity> accounts = findAll();
		for (UserAccountEntity entity : accounts)
		{
			if(username.equals(entity.getUsername()))
			{
				return entity;
			}
		}
		return null;
	}
	
}
