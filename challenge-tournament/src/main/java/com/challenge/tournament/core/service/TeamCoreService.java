package com.challenge.tournament.core.service;

import java.util.List;

import com.challenge.tournament.domain.Team;
import com.challenge.tournament.domain.TeamDTO;
import com.challenge.tournament.request.TeamRequest;
/**
 * returns data about teams
 * @author serge.akoa.owona
 *
 */
public interface TeamCoreService {
	
	/**
	 * returns list of teams given an ID
	 * @param id
	 * 			to identify a league
	 * @return
	 * 	      List of teams associated with the league.
	 */
	List<Team> retrieveTeamsByLeague(int id);

	TeamDTO retrieveTeam(String id);

	void deleteTeam(String id);

	void updateTeam(String id, TeamRequest teamRequest);

	void addTeam(TeamRequest teamRequest);


}
