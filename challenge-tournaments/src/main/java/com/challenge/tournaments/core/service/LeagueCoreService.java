package com.challenge.tournaments.core.service;

import java.util.List;

import com.challenge.tournaments.domain.League;

/**
 * Core Service to retrieve League related data
 * @author serge.akoa.owona
 *
 */
public interface LeagueCoreService {
	
	/**
	 * retrieve League raw data.
	 * @return
	 * 		  League related data.
	 */
	List<League> retrieveLeagues();

}
