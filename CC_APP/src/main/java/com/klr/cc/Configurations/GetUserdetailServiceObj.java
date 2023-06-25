package com.klr.cc.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.klr.cc.Entity.AuthDetails;
import com.klr.cc.Repositorities.AuthDetailsRepository;

import jakarta.servlet.http.HttpSession;

public class GetUserdetailServiceObj implements UserDetailsService {
	
	@Autowired
	private AuthDetailsRepository repo;
	
	@Autowired
	HttpSession session;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AuthDetails data = repo.findById(username).get();
		session.setAttribute("abc",data.getId());
		UserDetails user = User.withUsername(data.getUsername())
							   .password(data.getPassword())
							   .roles(data.getRoles().split(","))
							   .build();
		
		return user;
	}

}
