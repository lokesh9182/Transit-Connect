package com.klr.cc.Trip_BookingService;

import java.util.List;

import com.klr.cc.Entity.Booking;

public interface BookingService {

	void addBooking(int seats, String tripId, String seekerId);

	List<Booking> fetchAllBookings();

	void updatebookingStatus(String booking_Id);

	Booking getBookingById(String bookingid);

}
