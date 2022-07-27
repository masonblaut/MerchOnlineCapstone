package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserPhoneNum() {
		return userPhoneNum;
	}

	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}

	public String getUserAddress1() {
		return userAddress1;
	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}

	public String getUserAddress2() {
		return userAddress2;
	}

	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserZip() {
		return userZip;
	}

	public void setUserZip(String userZip) {
		this.userZip = userZip;
	}
	
}
