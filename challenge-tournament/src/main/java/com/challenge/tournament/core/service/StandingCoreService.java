package com.challenge.tournament.core.service;

import java.util.List;



import com.challenge.tournament.domain.Standing;
import com.challenge.tournament.dto.StandingDTO;
import com.challenge.tournament.request.StandingRequest;

public interface StandingCoreService {
	
	List<Standing> retrieveStandingsByLeague(int leagueId);

	StandingDTO retrieveLocation(String id);

	void deleteLocation(String id);

	void updateLocation(String id, StandingRequest standingRequest);

	void addLocation(StandingRequest standingRequest);

}
