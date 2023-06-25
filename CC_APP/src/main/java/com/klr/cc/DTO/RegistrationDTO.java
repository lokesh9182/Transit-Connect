package com.klr.cc.DTO;

import java.time.LocalDate;

public class RegistrationDTO {
	private String username;
	private String password;
	private String who;
	private String firstName;
	private String lastName;
	private String phone;
	private String aadhar;
	private String email;
	private String address;
	private String drivingLicenceNo;
	private LocalDate validUpto;
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
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
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
	public String getDrivingLicenceNo() {
		return drivingLicenceNo;
	}
	public void setDrivingLicenceNo(String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}
	public LocalDate getValidUpto() {
		return validUpto;
	}
	public void setValidUpto(LocalDate validUpto) {
		this.validUpto = validUpto;
	}
	@Override
	public String toString() {
		return "RegistrationDTO [username=" + username + ", password=" + password + ", who=" + who + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phone=" + phone + ", aadhar=" + aadhar + ", email=" + email
				+ ", address=" + address + ", drivingLicenceNo=" + drivingLicenceNo + ", validUpto=" + validUpto + "]";
	}
	
	
	
	

}
