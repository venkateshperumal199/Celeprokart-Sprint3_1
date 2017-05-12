package com.celeprokart.bean;

public class LoginBean {

	private String email,pass; 
	private String name;
	private int id;
	  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {  
	    return email;  
	}  
	  
	public void setEmail(String email) {  
	    this.email = email;  
	}  
	  
	public String getPass() {  
	    return pass;  
	}  
	  
	public void setPass(String pass) {  
	    this.pass = pass;  
	}  
	  
	
}
