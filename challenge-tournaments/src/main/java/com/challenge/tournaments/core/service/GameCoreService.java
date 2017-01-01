package com.challenge.tournaments.core.service;

import java.util.List;

import com.challenge.tournaments.domain.Game;

public interface GameCoreService {
	
	List<Game> retrieveGamesByLeague(int leagueId);

}
