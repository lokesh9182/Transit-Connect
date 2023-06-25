package com.klr.cc.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Booking {

	@Id
	private String bookingId;
	private int numberOfSeat;
	private String seekerId;
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tripId")
	@JsonIgnore
	private Trip trip;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	public String getSeekerId() {
		return seekerId;
	}

	public void setSeekerId(String seekerId) {
		this.seekerId = seekerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", numberOfSeat=" + numberOfSeat + ", seekerId=" + seekerId
				+ ", status=" + status + "]";
	}



}
