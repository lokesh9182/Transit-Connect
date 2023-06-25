package com.klr.cc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.klr.cc.Configurations.ConfigurationClass;
import com.klr.cc.Entity.AuthDetails;
import com.klr.cc.Entity.RideSeeker;
import com.klr.cc.Entity.Trip;
import com.klr.cc.Repositorities.AuthDetailsRepository;
import com.klr.cc.RideSeekerService.RideSeekerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RideSeekerController {
	
	@Autowired
	RideSeekerService seeker_service;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	AuthDetailsRepository userrepo;
	
	@PreAuthorize("hasAuthority('ROLE_SEEKER')")
	@GetMapping("/getUserDashboard")
	public String dahboard() {
		return "seeker/userDashboard";
	}
	
//	@PreAuthorize("hasAuthority('ROLE_NONE')")
//	@GetMapping("/register-rideseeker")
//	public String registerSeeker(Model model) {
//		model.addAttribute("seeker-dto",new RideSeeker());
//		return "seeker/rideSeekerRegistrationForm";
//	}
	
	@PreAuthorize("hasAuthority('ROLE_NONE')")
	@PostMapping("process-seekerRegistration")
	public String processRegistration(RideSeeker seeker) {
		seeker_service.RegisterRideSeeker(seeker);
		return "redirect:/getUserDashboard";
	}
	
	@PreAuthorize("hasAuthority('ROLE_SEEKER')")
	@GetMapping("/getAvalilableTrips")
	public String availableTrips(Model model) {
		List<Trip> trips =seeker_service.getavailableTrips();
		model.addAttribute("AvailableTrips",trips);
		model.addAttribute("allTrips",trips);
		return "seeker/availableTrips";
	}
	
	
	@PreAuthorize("hasAuthority('ROLE_SEEKER')")
	@GetMapping("/MyBookings")
	public String getMyBookings( Model model) {
		model.addAttribute("bookings",seeker_service.getMyBookings((String)session.getAttribute("abc")));
		
		return "seeker/Mybookings";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
