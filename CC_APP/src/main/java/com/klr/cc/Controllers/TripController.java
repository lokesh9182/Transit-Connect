package com.klr.cc.Controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.klr.cc.Entity.Trip;
import com.klr.cc.Trip_BookingService.TripService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TripController {
	
	@Autowired 
	HttpSession session;
	
	@Autowired
	TripService tripservice;
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@GetMapping("/RegisterNewTrip/{providerId}")
	public String TripRegistration(Model model, @PathVariable String providerId) {
		model.addAttribute("Trip-Registration-dto",new Trip());
		providerId=(String) session.getAttribute("abc");
		model.addAttribute("Vehicles",tripservice.fetchAllvehicles(providerId));
		model.addAttribute("ProviderID",providerId);
	
		return "provider/TripRegistrationForm";
	}
	
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@PostMapping("/Process-RegisterNewTrip/{ProviderID}")
	public String insertTrip(Trip trip, @PathVariable String ProviderID) {
		ProviderID=(String) session.getAttribute("abc");
		tripservice.insertTrip(trip,ProviderID);
//		return "redirect:/getAllTrips/All/"+ProviderID;
		return "redirect:/tripDetails/"+trip.getCreatorUserId()+"/"+trip.getTripId()+"/Provider";
	}
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@GetMapping("/getAllTrips/{status}/{providerId}")
	public String getAllTrips(@PathVariable String providerId,@PathVariable String status,Model model){
		providerId=(String) session.getAttribute("abc");
		model.addAttribute("TripData",tripservice.findTripsByproviderId(providerId));
		model.addAttribute("status",status);
		return "provider/ListOfTrips";
	}
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@GetMapping("/updateTrip/{ProviderId}/{tripid}")
	public String updateTrip(@PathVariable String tripid,@PathVariable String ProviderId,Model model) {
		Trip trip = tripservice.FetchTripByTripId(tripid);
		model.addAttribute("Trip-Registration-dto",trip);
		model.addAttribute("Vehicles",tripservice.fetchAllvehicles(ProviderId));
		model.addAttribute("ProviderID",ProviderId);
		
		return "provider/TripRegistrationForm";
	}
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER') or hasAuthority('ROLE_SEEKER')")
	@GetMapping("/tripDetails/{ProviderId}/{TripId}/{role}")
	public String tripDetails(@PathVariable String TripId,@PathVariable String ProviderId,Model model,@PathVariable String role) {
		model.addAttribute("Trip",tripservice.FetchTripByTripId(TripId));
		model.addAttribute("role",role);
		return "tripDetails";
	}
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@GetMapping("/cancelTrip/{ProviderId}/{tripid}")
	public String cancelTrip(@PathVariable String tripid,@PathVariable String ProviderId ) {
		tripservice.cancelTrip(tripid);
		return "redirect:/tripDetails/"+ProviderId+"/"+tripid+"/Provider";
		
	}
	

	//Filter trips based on source, Destination, date and time
	@PreAuthorize("hasAuthority('ROLE_SEEKER')")
	@RequestMapping("/filterBySDDT")
	public String FilterBySDDT( Model model,
									@RequestParam("source") String  source,
									@RequestParam("destination") String  destination,
									@RequestParam("date") LocalDate  date,
									@RequestParam("time") LocalTime  time){
		
		// default values of date=2023-01-01 and default time=00:00:00 else here parse of date and time can't possible and throws exception
		if(date.equals(LocalDate.parse("2023-01-01"))) date =null;
		if(time.equals(LocalTime.parse("00:00:00"))) time = null;
		Map<String,HashSet<String>> map = new HashMap<>();
		List<Trip> alltrips = tripservice.fetchAllTrips();
		map.put("source",new HashSet<>());
		map.put("destination", new HashSet<>());
		for(Trip trip:alltrips) {
			map.get("source").add(trip.getFromLoc());
			map.get("destination").add(trip.getToLoc());
		}
		model.addAttribute("map",map);
		model.addAttribute("AvailableTrips",tripservice.filterTripsBySDDT(source,destination,date,time));
		
		return "availableTrips";
	}
	
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@GetMapping("/getTripBookings/{Tripid}")
	public String getTripBookings(@PathVariable String Tripid,Model model) {
		model.addAttribute("tripBookings",tripservice.getAllBookingsOfTrip(Tripid));
		return "provider/TripBookings";
	}
	
	
	
//	@DeleteMapping("/deleteTrip/{TripId}")
//	public void DeleteTrip(@PathVariable String TripId) {
//		System.out.println(TripId);
//		tripservice.deleteTrip(TripId);
//	}
	

}
