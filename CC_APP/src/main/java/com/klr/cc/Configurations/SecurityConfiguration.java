package com.klr.cc.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
	
	@Autowired
	PasswordEncoder encoder;
	
	//InMemory Authentication
	//-----------------------------**************************************
	/*
	 * @Bean UserDetailsService uds() { UserDetails user1 =
	 * User.withUsername("root").password(encoder.encode("123")).roles("ADMIN").
	 * build(); return new InMemoryUserDetailsManager(user1); }
	 */
	
	
	//DB Authentication
	//-----------------------------**************************************
	
	@Bean
	UserDetailsService uds() {
		return new GetUserdetailServiceObj();
	}
	
	@Bean
	AuthenticationProvider auth_provider() {
		DaoAuthenticationProvider dao_auth_provider = new DaoAuthenticationProvider();
		dao_auth_provider.setUserDetailsService(uds());
		dao_auth_provider.setPasswordEncoder(encoder);
		return dao_auth_provider;
	}
	
	
	
	@Bean 
	SecurityFilterChain sfc( HttpSecurity http) throws Exception {
		
		return http
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(
				req->req.requestMatchers("/none").authenticated()
					    .anyRequest().permitAll()
								)
		.formLogin(login->login.loginPage("/login")
							   .loginProcessingUrl("/process-login")
						)
		.logout(logout->logout
							.logoutUrl("/signout")
							.logoutSuccessUrl("/login"))
		.exceptionHandling(
				e->e.accessDeniedPage("/accessDenied"))
		
		.build();
		
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
