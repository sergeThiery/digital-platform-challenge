package com.challenge.tournament.composite.service;

import com.challenge.tournament.dto.LeagueDataDTO;


/**
 * Composite service to return composite data about leagues
 * @author serge.akoa.owona
 *
 */
public interface LeaguesCompositeService {
	
	/**
	 * returns composite data about a league
	 * @param id to identify a league
	 * @return
	 * 		composite data about a league, given an ID.
	 */
	LeagueDataDTO retrieveCompositeDataLeague(int id);

}
