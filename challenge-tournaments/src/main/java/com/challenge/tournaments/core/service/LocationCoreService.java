package com.challenge.tournaments.core.service;

import java.util.List;

import com.challenge.tournaments.domain.Location;

public interface LocationCoreService {
	
	List<Location> getAllLocations();
	
	List<Location> getAllLocationsByLeague(int leagueId);

}
