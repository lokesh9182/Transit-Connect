package com.klr.cc.Trip_BookingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klr.cc.Entity.Booking;
import com.klr.cc.Entity.RideInfo;
import com.klr.cc.Entity.Trip;
import com.klr.cc.Repositorities.BookingRepository;
import com.klr.cc.Repositorities.RideInfoRepository;
import com.klr.cc.Repositorities.TripRepository;

@Service
public class TripServiceImpl implements TripService {
	
	@Autowired
	TripRepository trip_repo;
	
	@Autowired
	BookingRepository booking_repo;
	
	@Autowired
	RideInfoRepository rideInfo_repo;
	
	
	private String generateRideID(Trip trip) {
		String id=  trip.getFromLoc().substring(0,2)+
					trip.getToLoc().substring(0, 2)+
					trip.getRideTime().toString().substring(0,2)+
					trip.getRideTime().toString().substring(3,5);   
		return id;
	}

	private Boolean validateTrip(Trip trip) {
		
		List<String> allowedValuesForRideStatus = Arrays.asList("Planed","Started","Completed","Canceled");
		if(! allowedValuesForRideStatus.contains(trip.getRideStatus())) return false;
		if(trip.getFromLoc().equalsIgnoreCase(trip.getToLoc())) return false;
		if(trip.getRideDate().isBefore(LocalDate.now()))return false;
		if(trip.getRideDate().isEqual(LocalDate.now())) {
			if(trip.getRideTime().isBefore(LocalTime.now())) return false;
			}
		
		return true;
	}
	
	@Override
	public void insertTrip(Trip trip ,String ProviderID) {
		
		if(validateTrip(trip)) {
			if(trip.getTripId().equals("")) {
				trip.setTripId(generateRideID(trip));
				trip.setCreatorUserId(ProviderID);
				trip.setNoOfSeats(rideInfo_repo.findById(trip.getVechileId()).get().getNoOfSeats());
				
				trip.setSeatsFilled(0);
			}
			trip_repo.save(trip);
		
		}
		else {
			throw new RuntimeException("Buisiness Rules Vialation for fields in Ride");
		}
	}
	
	


	@Override
	public List<Trip> fetchAllTrips() {
		return trip_repo.findAll();
	}



	@Override
	public void updateTrip(Trip trip) {
		trip_repo.save(trip);
	}



	@Override
	public void deleteTrip(String tripId) {
//		System.out.println(trip_repo.findById(tripId));
			trip_repo.deleteById(tripId);
	}



	@Override
	public void cancelTrip(String tripid) {
		Trip trip = trip_repo.getById(tripid);
		trip.setRideStatus("Canceled");
		trip_repo.save(trip);
	}

	@Override
	public List<Trip> filterTripsBySDDT(String source, String destination, LocalDate l_date, LocalTime l_time) {
		//here default is form return value if user not select any source used to consider all sources
		if(source.equals("default")) source="%";
		if(destination.equals("default")) destination="%";
		return trip_repo.findByDate(l_date,l_time,source,destination);
	}

	@Override
	public List<RideInfo> fetchAllvehicles(String ProviderId) {
		return rideInfo_repo.findRidesByRP_Id(ProviderId);
		
	}

	@Override
	public List<Trip> findTripsByproviderId(String providerId) {
		
		return trip_repo.findByCreatorUserId(providerId);
	}

	@Override
	public Trip FetchTripByTripId(String tripid) {
		return trip_repo.findById(tripid).get();
		
	}

	@Override
	public List<Booking> getAllBookingsOfTrip(String tripid) {
		return booking_repo.findByTrip(tripid);
		
	}

}
