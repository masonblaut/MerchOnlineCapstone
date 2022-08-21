package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * User Account Entity Object used for Data Level operations.
 * @author Mason Blaut
 * @version 1.0
 */
@Table("user_account")
public class UserAccountEntity {

	@Id
	Long id;
	
	@Column("first_name")
	String userFirstName;
	
	@Column("last_name")
	String userLastName;
	
	@Column("email")
	String userEmail;
	
	@Column("username")
	String username;
	
	@Column("password")
	String password;
	
	@Column("phone")
	String userPhoneNum;
	
	@Column("address1")
	String userAddress1;
	
	@Column("address2")
	String userAddress2;
	
	@Column("city")
	String userCity;
	
	@Column("state")
	String userState;
	
	@Column("zip")
	String userZip;
	/**
	 * Constructor with fields.
	 * @param id Long
	 * @param userFirstName String
	 * @param userLastName String
	 * @param userEmail String
	 * @param username String
	 * @param password String
	 * @param userPhoneNum String
	 * @param userAddress1 String
	 * @param userAddress2 String
	 * @param userCity String
	 * @param userState String
	 * @param userZip String
	 */
	public UserAccountEntity(Long id, String userFirstName, String userLastName, String userEmail, String username,
			String password, String userPhoneNum, String userAddress1, String userAddress2, String userCity,
			String userState, String userZip) {
		super();
		this.id = id;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.username = username;
		this.password = password;
		this.userPhoneNum = userPhoneNum;
		this.userAddress1 = userAddress1;
		this.userAddress2 = userAddress2;
		this.userCity = userCity;
		this.userState = userState;
		this.userZip = userZip;
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
	 * getUserFirstName method
	 * @return userFirstName String
	 */
	public String getUserFirstName() {
		return userFirstName;
	}
	/**
	 * setUserFirstName method
	 * @param userFirstName String
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	/**
	 * getUserLastName method
	 * @return userLastName String
	 */
	public String getUserLastName() {
		return userLastName;
	}
	/**
	 * setUserLastName method
	 * @param userLastName String
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	/**
	 * getUserEmail method
	 * @return userEmail String
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * setUserEmail method
	 * @param userEmail String
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * getUsername method
	 * @return username String
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * setUsername method
	 * @param username String
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * getPassword method
	 * @return password String
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setPassword method
	 * @param userPassword String
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * getUserPhoneNum method
	 * @return userPhoneNum String
	 */
	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	/**
	 * setUserPhoneNum method
	 * @param userPhoneNum String
	 */
	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}
	/**
	 * getUserAddress1 method
	 * @return userAddress1 String
	 */
	public String getUserAddress1() {
		return userAddress1;
	}
	/**
	 * setUserAddress1 method
	 * @param userAddress1 String
	 */
	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}
	/**
	 * getUserAddress2 method
	 * @return userAddress2 String
	 */
	public String getUserAddress2() {
		return userAddress2;
	}
	/**
	 * setUserAddress2 method
	 * @param userAddress2 String
	 */
	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}
	/**
	 * getUserCity method
	 * @return userCity String
	 */
	public String getUserCity() {
		return userCity;
	}
	/**
	 * setUserCity method
	 * @param userCity String
	 */
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	/**
	 * getUserState method
	 * @return userState String
	 */
	public String getUserState() {
		return userState;
	}
	/**
	 * setUserState method
	 * @param userState String
	 */
	public void setUserState(String userState) {
		this.userState = userState;
	}
	/**
	 * getUserZip method
	 * @return userZip String
	 */
	public String getUserZip() {
		return userZip;
	}
	/**
	 * setUserZip method
	 * @param userZip String
	 */
	public void setUserZip(String userZip) {
		this.userZip = userZip;
	}
	
}
