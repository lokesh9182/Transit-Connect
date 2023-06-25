package com.klr.cc.Repositorities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.klr.cc.Entity.Trip;

public interface TripRepository extends JpaRepository<Trip, String>{
	
	@Query("SELECT e FROM Trip e WHERE (e.rideDate = :date OR :date IS NULL) and (e.rideTime = :time OR :time IS NULL) and e.fromLoc LIKE :source and e.toLoc LIKE :destination ")
	List<Trip> findByDate(@Param("date") LocalDate date,@Param("time") LocalTime time, @Param("source") String source, @Param("destination") String destination);

	List<Trip> findByCreatorUserId(String creatorUserId);
}
