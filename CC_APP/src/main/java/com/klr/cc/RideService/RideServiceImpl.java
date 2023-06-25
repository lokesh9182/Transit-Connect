package com.klr.cc.RideService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klr.cc.Entity.RideInfo;
import com.klr.cc.Entity.RideProvider;
import com.klr.cc.Repositorities.RideInfoRepository;
import com.klr.cc.Repositorities.RideProviderRepository;

@Service
public class RideServiceImpl implements RideService {
	
	@Autowired
	RideInfoRepository ride_repo;
	
	@Autowired
	RideProviderRepository rp_repo;

	@Override
	public String registerRide(RideInfo ride, String rideId) {
		
		Optional<RideProvider> rp = rp_repo.findById(rideId);
		if(!rp.isEmpty()) {
			
			ride.setRide_provider(rp.get());
			ride_repo.save(ride);
		}
		return ride.getVehicleNo();
	}

	@Override
	public RideInfo getRideById(String veh_No) {
		
		return ride_repo.findById(veh_No).get();
	}
	
	
	
	
	
	
	
	

}
