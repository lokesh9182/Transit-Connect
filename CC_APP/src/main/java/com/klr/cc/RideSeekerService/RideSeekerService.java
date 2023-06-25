package com.klr.cc.RideSeekerService;

import java.util.List;

import com.klr.cc.Entity.Booking;
import com.klr.cc.Entity.RideSeeker;
import com.klr.cc.Entity.Trip;

public interface RideSeekerService {

	String RegisterRideSeeker(RideSeeker seeker);

	List<Trip> getavailableTrips();

	List<Booking> getMyBookings(String seekerId);

}
