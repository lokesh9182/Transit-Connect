package com.klr.cc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.klr.cc.Trip_BookingService.BookingService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {
	

	@Autowired
	BookingService b_service;
	
	@Autowired
	HttpSession session;
	

	
	@PreAuthorize("hasAuthority('ROLE_SEEKER')")
	@GetMapping("/bookTrip/{TripId}")
	public String bookTrip(@PathVariable String TripId) {
		int seats=3;
		b_service.addBooking(seats, TripId,(String) session.getAttribute("abc"));
		return "redirect:/MyBookings";
	}
	
	
	/*
	 * @GetMapping("/getMyBookings/{SeekerId}") public String GetMybookings(Model
	 * model, @PathVariable String SeekerId) { return "MyBookings"; }
	 */
	
//	
//	@GetMapping("/getAllBookings")
//	public List<Booking> allBookings() {
//		return b_service.fetchAllBookings();
//	}

	@PreAuthorize("hasAuthority('ROLE_SEEKER')")
	@GetMapping("/cancelBooking/{booking_Id}")
	public String cancelBooking(@PathVariable String booking_Id) {
		b_service.updatebookingStatus(booking_Id);
		return "redirect:/MyBookings";
	}
	
	@PreAuthorize("hasAuthority('ROLE_SEEKER')")
	@GetMapping("/getBookingDetails/{Bookingid}/{Tripid}")
	public String getBookingdetails(Model model,@PathVariable String Bookingid) {
		model.addAttribute("BookingData",b_service.getBookingById(Bookingid));
		return "BookingDetails";
	}

}
