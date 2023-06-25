package com.klr.cc.RideService;

import com.klr.cc.Entity.RideInfo;

public interface RideService {

	String registerRide(RideInfo ride, String rpid);

	RideInfo getRideById(String veh_No);

}
