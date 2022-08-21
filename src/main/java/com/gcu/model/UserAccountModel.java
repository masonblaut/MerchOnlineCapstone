package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * User Account Model Object used for Business Level operations.
 * @author Mason Blaut
 * @version 1.0
 */
public class UserAccountModel {
	
	private Long idNumber;

	@NotNull(message="First Name field cannot be empty!")
	@Size(min=1, max=32, message="Your first name must be between 1 and 32 characters long!")
	private String userFirstName;
	
	@NotNull(message="Last Name field cannot be empty!")
	@Size(min=1, max=32, message="Your last name must be between 1 and 32 characters long!")
	private String userLastName;
	
	@NotNull(message="Email field cannot be empty!")
	@Size(min=1, max=50, message="Your email must be between 1 and 50 characters long!")
	private String userEmail;

	@NotNull(message="User name field cannot be empty!")
	@Size(min=1, max=32, message="Your user name must be between 1 and 32 characters long!")
	private String username;

	@NotNull(message="Password field cannot be empty!")
	@Size(min=1, max=32, message="Your password must be between 1 and 32 characters long!")
	private String password;
	
	@NotNull(message="Phone Number field cannot be empty!")
	@Size(min=10, max=10, message="Your phone number must be contain 10 characters, (only numbers please)!")
	private String userPhoneNum;
	
	@NotNull(message="Address field cannot be empty!")
	@Size(min=4, max=60, message="Your address must be between 4 and 60 characters long!")
	private String userAddress1;
	
	@Size(min=0, max=60, message="Your address 2 can be between 0 and 60 characters long!")
	private String userAddress2;
	
	@NotNull(message="Address City field cannot be empty!")
	@Size(min=1, max=32, message="Your city must be between 1 and 32 characters long!")
	private String userCity;
	
	@NotNull(message="Address State field cannot be empty!")
	@Size(min=2, max=2, message="Your state must be 2 characters long! (ex. AZ)")
	private String userState;
	
	@NotNull(message="Address ZIP Code field cannot be empty!")
	@Size(min=5, max=5, message="Your zipcode must be 5 characters long!")
	private String userZip;
	/**
	 * getIdNumber method
	 * @return idNumber Long
	 */
	public Long getIdNumber() {
		return idNumber;
	}
	/**
	 * setIdNumber method
	 * @param idNumber Long
	 */
	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
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
