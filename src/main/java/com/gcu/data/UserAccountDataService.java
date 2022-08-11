package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserAccountEntity;
import com.gcu.data.repository.UserAccountRepository;


@Service
public class UserAccountDataService implements DataAccessInterface<UserAccountEntity> 
{

	@Autowired
	private UserAccountRepository userAccountRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
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
	
	public List<UserAccountEntity> findAll()
	{
		List<UserAccountEntity> accounts = new ArrayList<UserAccountEntity>();
		try
		{
			Iterable<UserAccountEntity> ordersIterable = userAccountRepository.findAll();
			
			accounts = new ArrayList<UserAccountEntity>();
			ordersIterable.forEach(accounts::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return accounts;
	}
	
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
