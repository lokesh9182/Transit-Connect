package com.klr.cc.Trip_BookingService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klr.cc.Entity.Booking;
import com.klr.cc.Entity.Trip;
import com.klr.cc.Repositorities.BookingRepository;
import com.klr.cc.Repositorities.TripRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository book_repo;

	@Autowired
	TripRepository trip_repo;
	

	private String generateBookingId(Trip trip) {
		String id=  trip.getRideTime().toString().substring(0,2)+
					trip.getRideTime().toString().substring(3,5)+
					trip.getFromLoc().substring(0,2)+
					trip.getToLoc().substring(0, 2);   
		return id;
	}


	private boolean bookingValidation(Booking booking) {
		// Booking status values verification
		List<String> allowedBookingStatus = Arrays.asList("Booked", "Canceled", "Completed");
		if (! allowedBookingStatus.contains(booking.getStatus())) return false;
		
		//0 < No.of seats verification <Available seats
		if(booking.getNumberOfSeat()> 0 && booking.getNumberOfSeat() > (booking.getTrip().getNoOfSeats()-booking.getTrip().getSeatsFilled())) return false;
		
		//trip status verification
		if(! booking.getTrip().getRideStatus().equals("Planed")) return false;
		return true;
	}

	public void addBooking(int NoOfseats, String tripId, String seekerId) {
		Trip trip = trip_repo.findById(tripId).get();
		Booking booking = new Booking();
		booking.setStatus("Booked");
		booking.setNumberOfSeat(NoOfseats);
		booking.setTrip(trip);
		if (bookingValidation(booking)) {
			booking.setBookingId(generateBookingId(trip));
			// fetch seeker id based on authentication
			booking.setSeekerId(seekerId);
			if(! book_repo.existsById(booking.getBookingId())) {
				book_repo.save(booking);
				trip.setSeatsFilled(trip.getSeatsFilled()+NoOfseats);
				trip_repo.save(trip);
			}	
			
		} else {
			throw new RuntimeException("Buisiness Rules Vialation for fields in Ride");
		}

	}

	@Override
	public List<Booking> fetchAllBookings() {

		return book_repo.findAll();
	}


	@Override
	public void updatebookingStatus(String booking_Id) {
		Booking booking= book_repo.findById(booking_Id).get();
		booking.setStatus("Canceled");
		book_repo.save(booking);
		
	}


	@Override
	public Booking getBookingById(String bookingid) {
		
		return book_repo.findById(bookingid).get();
	}

}
