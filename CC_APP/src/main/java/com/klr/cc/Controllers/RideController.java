package com.klr.cc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.klr.cc.Entity.RideInfo;
import com.klr.cc.RideService.RideService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RideController {
	
	
	@Autowired
	RideService ride_service;
	
	@Autowired
	HttpSession session;
	

	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@GetMapping("/Register-ride/{rpid}")
	public String RegisterRide(@PathVariable String rpid,Model model) {
		model.addAttribute("Ride-Registration-dto",new RideInfo());
		model.addAttribute("RiderId",(String) session.getAttribute("abc"));
		return "provider/rideRegistrationForm";
	}
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@PostMapping("/process-Register-ride/{rpid}")
	public String registerRide(@PathVariable String rpid,RideInfo ride) {
		
		ride_service.registerRide(ride,rpid);
		return "redirect:/RegisterNewTrip/"+rpid;
	}
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@GetMapping("/UpdadateRide/{veh_No}")
	public String updateRidedata(@PathVariable("veh_No") String veh_No,Model model) {
		RideInfo ride = ride_service.getRideById(veh_No);
		model.addAttribute("Ride-Registration-dto",ride);
		model.addAttribute("RiderId",ride.getRide_provider().getRpId());
		return "provider/rideRegistrationForm";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
