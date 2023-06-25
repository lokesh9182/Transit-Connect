package com.klr.cc.RideProviderService;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klr.cc.Entity.RideProvider;
import com.klr.cc.Repositorities.RideProviderRepository;

@Service
public class RideProviderServiceImpl implements RideProviderService {
	
	@Autowired
	RideProviderRepository rp_repo;
	
	private String GenerateRideProviderId(RideProvider provider) {
		
		return "RP"+provider.getLastName().substring(0, 2)+provider.getAdharCard().substring(0,2);
		
	}

	@Override
	public String registerRideProvider(RideProvider rp) {
		if(rp.getRpId().equals("")) {
			rp.setRpId(GenerateRideProviderId(rp));
			rp.setStatus("Registered");
		}
		rp_repo.save(rp);
		
		return rp.getRpId();
	}
	
	

	@Override
	public void UnRegisterRideProvider(String providerId) {
		RideProvider getrideProviderById = GetrideProviderById(providerId);
		getrideProviderById.setStatus("Un-registered");
		rp_repo.save(getrideProviderById);
		
		
	}



	@Override
	public RideProvider GetrideProviderById(String ProviderId) {
		
		Optional<RideProvider> provider = rp_repo.findById(ProviderId);
	
		return provider.get();
		
	}
	
	

}
