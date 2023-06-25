package com.klr.cc.Controllers;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.klr.cc.DTO.LoginDTO;
import com.klr.cc.DTO.RegistrationDTO;
import com.klr.cc.Entity.AuthDetails;
import com.klr.cc.Entity.RideProvider;
import com.klr.cc.Entity.RideSeeker;
import com.klr.cc.Repositorities.AuthDetailsRepository;
import com.klr.cc.RideProviderService.RideProviderService;
import com.klr.cc.RideSeekerService.RideSeekerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	RideProviderService providerservice;
	
	@Autowired
	Environment env;
	
	@Autowired
	RideSeekerService seekerservice;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private AuthDetailsRepository authdetailsRepo;
	
	
	
	
	@GetMapping("/")
	public String loginsuccess(Authentication auth) {
		System.out.println("****************************************************************");
		if(auth.getAuthorities().toString().contains("ROLE_NONE")) return "redirect:/none";
		if(auth.getAuthorities().toString().contains("ROLE_PROVIDER")) return "redirect:/providerDashboard";
		return "redirect:/getUserDashboard";
		
	}
	
	@GetMapping("/home")
	public String homepage() {
		System.out.println(session.getAttribute("abc"));
		return "home";
	}
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("reg_dto",new RegistrationDTO());
		return "Registration";
	}
	
	
	@PostMapping("process-registration")
	public String processRegistration(RegistrationDTO dto) {
		
		String id, role;
		if(dto.getWho().equals("provider")) {
		RideProvider pro = new RideProvider(dto.getFirstName(), dto.getLastName(),dto.getPhone(),dto.getAadhar(),dto.getEmail(),"status",dto.getDrivingLicenceNo(),dto.getValidUpto());
		pro.setRpId("");
		id=providerservice.registerRideProvider(pro); 
		role="PROVIDER";}
		else {
			RideSeeker seeker = new RideSeeker("", dto.getFirstName(), dto.getLastName(), dto.getPhone(), dto.getAadhar(), dto.getEmail(), "", dto.getAddress());
			id=seekerservice.RegisterRideSeeker(seeker); 
			role="SEEKER";}
		
		AuthDetails user = new AuthDetails();
		user.setId(id);
		user.setUsername(dto.getUsername());
		user.setPassword(encoder.encode(dto.getPassword()));
		user.setRoles(role);
		authdetailsRepo.save(user);
		return "redirect:/login";
	}
	
	
	
	
	
	@GetMapping("/signup")
	public String signup(Model model) {
		
		return "db/newdb";
	}
	
	@PostMapping("/Process-signup")
	public String processSignup( AuthDetails user ) {
		user.setRoles("NONE");
		user.setPassword(encoder.encode(user.getPassword()));
		authdetailsRepo.save(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginForm",new LoginDTO());
		return "login";
	}
	
	
	@GetMapping("/none")
	@PreAuthorize("hasAuthority('ROLE_NONE')")
	public String register() {
		
		return "NONE";
	}
	
	@GetMapping("/accessDenied")
	public String denied() {
		return "seeker/accessDenied";
	}
	
}
