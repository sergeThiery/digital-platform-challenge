package com.challenge.tournament.core.service;

import java.util.List;

import com.challenge.tournament.dto.GameDTO;
import com.challenge.tournament.request.GameRequest;

public interface GameCoreService {
	
	List<GameDTO> retrieveGamesByLeague(int leagueId);
//	
//	void addGameByLeague(String leagueId);
//	
//	void deleteGameByLeague();
	
	void addGame(GameRequest gameRequest);
	
	void updateGame(String id, GameRequest gameRequest);
	
	void deleteGame(String id);
	
	GameDTO getGame(String id);

}
