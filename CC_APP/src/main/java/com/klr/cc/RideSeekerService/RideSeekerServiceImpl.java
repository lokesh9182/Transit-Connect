package com.klr.cc.RideSeekerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klr.cc.Entity.Booking;
import com.klr.cc.Entity.RideSeeker;
import com.klr.cc.Entity.Trip;
import com.klr.cc.Repositorities.BookingRepository;
import com.klr.cc.Repositorities.TripRepository;
import com.klr.cc.Repositorities.rideSeekerRepository;

@Service
public class RideSeekerServiceImpl implements RideSeekerService {

	@Autowired
	rideSeekerRepository seekerRepo;
	
	@Autowired
	TripRepository tripRepo;
	
	@Autowired
	BookingRepository bookingRepo;
	
	private String getSeekerId(RideSeeker seeker) {
		String seekerId= "RS"
					    +seeker.getAadhar().substring(0,4)
					    +seeker.getLastName().substring(0,2)
					    +seeker.getPhone().substring(0,2);
		
		return seekerId;
	}
	
	@Override
	public String RegisterRideSeeker(RideSeeker seeker) {
		seeker.setRsId(getSeekerId(seeker));
		seeker.setStatus("Registered");
		seekerRepo.save(seeker);
		return seeker.getRsId();
	}

	@Override
	public List<Trip> getavailableTrips() {
		return tripRepo.findAll();
		
	}

	@Override
	public List<Booking> getMyBookings(String seekerId) {
		
		return bookingRepo.findBySeekerId(seekerId);
	}

}
