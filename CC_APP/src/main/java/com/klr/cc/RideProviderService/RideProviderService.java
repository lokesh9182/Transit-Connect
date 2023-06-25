package com.klr.cc.RideProviderService;

import com.klr.cc.Entity.RideProvider;

public interface RideProviderService {

	String registerRideProvider(RideProvider rp);
	
	RideProvider GetrideProviderById(String ProviderId);

	void UnRegisterRideProvider(String providerId);

}
