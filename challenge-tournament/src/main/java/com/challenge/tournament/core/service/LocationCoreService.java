package com.challenge.tournament.core.service;

import java.util.List;

import com.challenge.tournament.domain.Location;
import com.challenge.tournament.dto.LocationDTO;
import com.challenge.tournament.request.LocationRequest;

public interface LocationCoreService {
	
	List<Location> getAllLocations();
	
	List<Location> getAllLocationsByLeague(int leagueId);
	
	LocationDTO retrieveLocation(String id);
	
	void deleteLocation(String id);
	
	void addLocation(LocationRequest locationRequest);
	
	void updateLocation(String id, LocationRequest locationRequest);

}
