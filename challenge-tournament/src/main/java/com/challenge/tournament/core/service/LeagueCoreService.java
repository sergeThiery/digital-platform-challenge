package com.challenge.tournament.core.service;

import java.util.List;

import com.challenge.tournament.domain.League;
import com.challenge.tournament.dto.LeagueDTO;
import com.challenge.tournament.request.LeagueRequest;
import com.challenge.tournament.request.LeagueToDeleteRequest;

/**
 * Core Service to retrieve League related data
 * 
 * @author serge.akoa.owona
 *
 */
public interface LeagueCoreService {

	/**
	 * retrieve all leagues
	 * 
	 * @return the list of all leagues
	 */
	List<League> retrieveLeagues();

	/**
	 * retrieves a league
	 * 
	 * @param id
	 *            the league ID
	 * @return League related data.
	 */
	LeagueDTO retrieveLeague(int id);
	
    /**
     * Deletes a list of leagues
     * @param requestList
     * 					list of leagues to delete
     */
	void deleteLeagues(List<LeagueToDeleteRequest> requestList);

    /**
     * update a league
     * @param name
     * 			The name of the league  -- entry to update.
     * @param year
     * 			The year in which the league exists -- entry to update
     * @param leagueRequest
     * 			The information to replace existing one
     */
	void updateLeague(String name, int year , LeagueRequest leagueRequest);

    /**
     * creates a new league
     * @param leagueRequest
     * 						contains the properties of a league
     */
	void addLeague(LeagueRequest leagueRequest);

}
