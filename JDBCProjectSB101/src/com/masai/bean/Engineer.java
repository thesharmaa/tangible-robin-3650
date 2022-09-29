package com.masai.bean;

public class Engineer {

	String username;
	String password;
	String category;
	public Engineer(String username, String password, String category) {
		super();
		this.username = username;
		this.password = password;
		this.category = category;
	}
	public Engineer() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Engineer [username=" + username + ", password=" + password + ", category=" + category + "]";
	}
	
	
}
