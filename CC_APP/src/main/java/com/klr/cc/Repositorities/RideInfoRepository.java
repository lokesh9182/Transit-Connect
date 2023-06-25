package com.klr.cc.Repositorities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klr.cc.Entity.RideInfo;

public interface RideInfoRepository extends JpaRepository<RideInfo,String> {
	
	@Query("select r from RideInfo r where r.ride_provider.rpId = :providerId")
	List<RideInfo> findRidesByRP_Id(String providerId);

}
