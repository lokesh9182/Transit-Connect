package com.klr.cc.Repositorities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.klr.cc.Entity.Booking;
import com.klr.cc.Entity.Trip;

public interface BookingRepository extends JpaRepository<Booking, String>{
	
	List<Booking> findBySeekerId(String seekerId);
	
	@Query("select b from Booking b where b.trip.tripId=:id")
	List<Booking> findByTrip(@Param("id") String tripid);
	
	

}
