package com.klr.cc.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RideInfo {
	@Id
	private String vehicleNo;
	private String carType;
	private String carName;
	private String fuelType;
	private int noOfSeats;
	
	@ManyToOne
	@JoinColumn(name="rpId")
	@JsonIgnore
	private RideProvider ride_provider;

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
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

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public RideProvider getRide_provider() {
		return ride_provider;
	}

	public void setRide_provider(RideProvider ride_provider) {
		this.ride_provider = ride_provider;
	}

	@Override
	public String toString() {
		return "RideInfo [vehicleNo=" + vehicleNo + ", carType=" + carType + ", carName=" + carName + ", fuelType="
				+ fuelType + ", noOfSeats=" + noOfSeats + "]";
	}

	
	
}
