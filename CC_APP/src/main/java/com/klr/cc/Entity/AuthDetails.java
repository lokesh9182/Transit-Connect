package com.klr.cc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AuthDetails {
	@Id
	private String username;
	private String password;
	private String roles;
	private String id;
	
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
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "AuthDetails [username=" + username + ", password=" + password + ", roles=" + roles + ", id=" + id + "]";
	}
	
	

}
