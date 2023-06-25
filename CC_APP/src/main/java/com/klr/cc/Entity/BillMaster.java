package com.klr.cc.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BillMaster {
	@Id
	private String billId;
	private String rideId;
	private int noOfKm;
	private int totalBill;
	private int noOfOccupants;
	private int feeId;
	private int costPerOccupant;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Fees_Id")
	@JsonIgnore
	private Fees fees;

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getRideId() {
		return rideId;
	}

	public void setRideId(String rideId) {
		this.rideId = rideId;
	}

	public int getNoOfKm() {
		return noOfKm;
	}

	public void setNoOfKm(int noOfKm) {
		this.noOfKm = noOfKm;
	}

	public int getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}

	public int getNoOfOccupants() {
		return noOfOccupants;
	}

	public void setNoOfOccupants(int noOfOccupants) {
		this.noOfOccupants = noOfOccupants;
	}

	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public int getCostPerOccupant() {
		return costPerOccupant;
	}

	public void setCostPerOccupant(int costPerOccupant) {
		this.costPerOccupant = costPerOccupant;
	}

	public Fees getFees() {
		return fees;
	}

	public void setFees(Fees fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "BillMaster [billId=" + billId + ", rideId=" + rideId + ", noOfKm=" + noOfKm + ", totalBill=" + totalBill
				+ ", noOfOccupants=" + noOfOccupants + ", feeId=" + feeId + ", costPerOccupant=" + costPerOccupant
				+ "]";
	}

	
	
	
}
