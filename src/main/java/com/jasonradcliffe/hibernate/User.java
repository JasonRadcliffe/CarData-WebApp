package com.jasonradcliffe.hibernate;

import java.util.Date;

public class User {
	
	private int UserID;
	private String Username;
	private String Password;
	
	
	public User(){
		
	}
	
	public User(String Username, String Password){
		this.setUsername(Username);
		this.setPassword(Password);
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}


	

}
