package com.challenge.tournaments.core.service;

import java.util.List;

import com.challenge.tournaments.domain.Team;

public interface TeamCoreService {
	
	List<Team> retrieveTeamsByLeague(int id);


}
