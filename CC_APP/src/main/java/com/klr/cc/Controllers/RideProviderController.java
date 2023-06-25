package com.klr.cc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.klr.cc.Entity.RideProvider;
import com.klr.cc.Repositorities.AuthDetailsRepository;
import com.klr.cc.RideProviderService.RideProviderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RideProviderController {
	@Autowired
	AuthDetailsRepository userrepo;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	RideProviderService rp_service;
	
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@GetMapping("/providerDashboard")
	public String dashBoard() {
		return "provider/providerDashboard";
	}
	
	
//	@PreAuthorize("hasAuthority('ROLE_NONE')")
//	@GetMapping("/Register_Ride_Provider")
//	public String RegisterRideProvider(Model model) {
//		model.addAttribute("Registration-dto",new RideProvider());
//		return "rideProviderRegistrationForm";
//	}
	
	
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@PostMapping("/Process-RideProvider-Registration")
	public String RegistrationOfRideProvider(RideProvider provider) {
		rp_service.registerRideProvider(provider);	
		return "redirect:/providerDashboard";
	}
//********************************************************************************************************	
	
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@GetMapping("/updateProvider")
	public String UpdateProviderDetails(Model model) {
		model.addAttribute("Registration-dto",rp_service.GetrideProviderById((String) session.getAttribute("abc")));
		return "provider/rideProviderRegistrationForm";
	}
	
	
	@PreAuthorize("hasAuthority('ROLE_PROVIDER')")
	@ResponseBody
	@GetMapping("/un-register/{rpid}")
	public String unRegisterRideProvider(@PathVariable("rpid") String providerId) {
		rp_service.UnRegisterRideProvider(providerId);
		return "Un-Regitered Successfully";
	}
	
	
	
}
