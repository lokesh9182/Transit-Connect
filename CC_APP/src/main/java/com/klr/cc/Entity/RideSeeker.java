package com.klr.cc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RideSeeker {
	
	@Id
	private String rsId;
	private String firstName;
	private String lastName;
	private String phone;
	private String aadhar;
	private String email;
	private String status;
	private String address;
	
	public RideSeeker() {}
	
	public RideSeeker(String rsId, String firstName, String lastName, String phone, String aadhar, String email,
			String status, String address) {
		super();
		this.rsId = rsId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.aadhar = aadhar;
		this.email = email;
		this.status = status;
		this.address = address;
	}
	public String getRsId() {
		return rsId;
	}
	public void setRsId(String rsId) {
		this.rsId = rsId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RideSeeker [rsId=" + rsId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", aadhar=" + aadhar + ", email=" + email + ", address=" + address + ", status=" + status + "]";
	}
	
	
	

}
