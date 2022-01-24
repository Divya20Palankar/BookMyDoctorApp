package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Admin extends User{
	//@Id
	//@GeneratedValue
	private int adminId;
	
	@NotEmpty(message = "Email is required")
	private String email;
	
	@NotEmpty(message = "Password is required")
	private String password;
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", email=" + email + ", password=" + password + "]";
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
