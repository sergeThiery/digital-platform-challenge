package com.challenge.tournaments.core.service;

import java.util.List;

import com.challenge.tournaments.domain.Standing;

public interface StandingCoreService {
	
	List<Standing> retrieveStandingsByLeague(int leagueId);

}
