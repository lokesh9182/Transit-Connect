package com.klr.cc.Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Trip {

	@Id
	private String tripId;
	private String creatorUserId;
	private String VechileId;
	private LocalDate rideDate;
	private LocalTime rideTime;
	private String rideStatus;
	private int noOfSeats;
	private int seatsFilled;
	private String fromLoc;
	private String toLoc;

	@OneToMany(targetEntity = Booking.class, cascade = CascadeType.ALL, mappedBy = "trip", fetch = FetchType.LAZY)
	
	private List<Booking> bookings = new ArrayList<>();

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(String creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public String getVechileId() {
		return VechileId;
	}

	public void setVechileId(String vechileId) {
		VechileId = vechileId;
	}

	public LocalDate getRideDate() {
		return rideDate;
	}

	public void setRideDate(LocalDate rideDate) {
		this.rideDate = rideDate;
	}

	public LocalTime getRideTime() {
		return rideTime;
	}

	public void setRideTime(LocalTime rideTime) {
		this.rideTime = rideTime;
	}

	public String getRideStatus() {
		return rideStatus;
	}

	public void setRideStatus(String rideStatus) {
		this.rideStatus = rideStatus;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getSeatsFilled() {
		return seatsFilled;
	}

	public void setSeatsFilled(int seatsFilled) {
		this.seatsFilled = seatsFilled;
	}

	public String getFromLoc() {
		return fromLoc;
	}

	public void setFromLoc(String fromLoc) {
		this.fromLoc = fromLoc;
	}

	public String getToLoc() {
		return toLoc;
	}

	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", creatorUserId=" + creatorUserId + ", VechileId=" + VechileId
				+ ", rideDate=" + rideDate + ", rideTime=" + rideTime + ", rideStatus=" + rideStatus + ", noOfSeats="
				+ noOfSeats + ", seatsFilled=" + seatsFilled + ", fromLoc=" + fromLoc + ", toLoc=" + toLoc + "]";
	}

}
