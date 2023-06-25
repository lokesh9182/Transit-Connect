package com.klr.cc.Configurations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigurationClass {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static Authentication updateAutentication(Authentication auth, String role) {
	    List<GrantedAuthority> newAuthorities = new ArrayList<>();
	    newAuthorities.add(new SimpleGrantedAuthority(role));

	    Authentication newAuth = UsernamePasswordAuthenticationToken.authenticated(
	            auth.getPrincipal(),
	            auth.getCredentials(),
	            newAuthorities);
	   
	    return newAuth;
	}


}
