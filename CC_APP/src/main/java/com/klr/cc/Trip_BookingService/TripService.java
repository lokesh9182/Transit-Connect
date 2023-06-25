package com.klr.cc.Trip_BookingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.klr.cc.Entity.Booking;
import com.klr.cc.Entity.RideInfo;
import com.klr.cc.Entity.Trip;


public interface TripService {

	void insertTrip(Trip trip ,String ProviderID);
	List<RideInfo> fetchAllvehicles(String ProviderId);

	List<Trip> fetchAllTrips();

	void updateTrip(Trip trip);

	void deleteTrip(String trip);

	void cancelTrip(String tripid);

	List<Trip> filterTripsBySDDT(String source, String destination, LocalDate l_date, LocalTime l_time);
	
	List<Trip> findTripsByproviderId(String providerId);
	
	Trip FetchTripByTripId(String tripid);
	List<Booking> getAllBookingsOfTrip(String tripid);
	

}
