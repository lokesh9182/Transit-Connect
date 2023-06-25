package com.klr.cc.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Fees {
	
	@Id
	private int feeId;
	private String carType;
	private String carName;
	private String fuelType;
	private int averageInKm;
	private int costOfFuel;
	private int wearTearCost;
	private int driverCharges;
	private int carPoolCommision;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity =BillMaster.class, mappedBy ="fees", fetch = FetchType.EAGER )
	private List<BillMaster> billMasters = new ArrayList<>();

	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getAverageInKm() {
		return averageInKm;
	}

	public void setAverageInKm(int averageInKm) {
		this.averageInKm = averageInKm;
	}

	public int getCostOfFuel() {
		return costOfFuel;
	}

	public void setCostOfFuel(int costOfFuel) {
		this.costOfFuel = costOfFuel;
	}

	public int getWearTearCost() {
		return wearTearCost;
	}

	public void setWearTearCost(int wearTearCost) {
		this.wearTearCost = wearTearCost;
	}

	public int getDriverCharges() {
		return driverCharges;
	}

	public void setDriverCharges(int driverCharges) {
		this.driverCharges = driverCharges;
	}

	public int getCarPoolCommision() {
		return carPoolCommision;
	}

	public void setCarPoolCommision(int carPoolCommision) {
		this.carPoolCommision = carPoolCommision;
	}

	public List<BillMaster> getBillMasters() {
		return billMasters;
	}

	public void setBillMasters(List<BillMaster> billMasters) {
		this.billMasters = billMasters;
	}

	@Override
	public String toString() {
		return "Fees [feeId=" + feeId + ", carType=" + carType + ", carName=" + carName + ", fuelType=" + fuelType
				+ ", averageInKm=" + averageInKm + ", costOfFuel=" + costOfFuel + ", wearTearCost=" + wearTearCost
				+ ", driverCharges=" + driverCharges + ", carPoolCommision=" + carPoolCommision +"]";
	}
	
	
	}
