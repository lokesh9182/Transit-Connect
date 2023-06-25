package com.klr.cc.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class RideProvider {
	@Id
	private String rpId;
	private String firstName;
	private String lastName;
	private String phone;
	private String adharCard;
	private String emailId;
	private String status;
	private String dlNo;
	private LocalDate validUpto;
	
	@OneToMany(targetEntity = RideInfo.class, mappedBy ="ride_provider",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RideInfo> Rides = new ArrayList<>();

	public String getRpId() {
		return rpId;
	}

	
	
	public RideProvider() {
		
	}



	public RideProvider(String firstName, String lastName, String phone, String adharCard, String emailId,
			String status, String dlNo, LocalDate validUpto) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.adharCard = adharCard;
		this.emailId = emailId;
		this.status = status;
		this.dlNo = dlNo;
		this.validUpto = validUpto;
	}



	public void setRpId(String rpId) {
		this.rpId = rpId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String string) {
		this.phone = string;
	}

	public String getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(String adharCard) {
		this.adharCard = adharCard;
	}

	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}

	public LocalDate getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(LocalDate validUpto) {
		this.validUpto = validUpto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<RideInfo> getRides() {
		return Rides;
	}

	public void setRides(List<RideInfo> rides) {
		Rides = rides;
	}

	@Override
	public String toString() {
		return "RideProvider [rpId=" + rpId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", phone=" + phone + ", adharCard=" + adharCard + ", dlNo=" + dlNo + ", validUpto="
				+ validUpto + ", status=" + status + ", Rides=" + Rides + "]";
	}
	
	
	
	

}
