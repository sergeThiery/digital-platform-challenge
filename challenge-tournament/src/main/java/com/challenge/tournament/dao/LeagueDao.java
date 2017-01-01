package com.challenge.tournament.dao;

import java.util.List;

import com.challenge.tournament.entity.LeagueEntity;

public interface LeagueDao {
	
	
	List<LeagueEntity> findAll();
    void insertLeague(LeagueEntity league);
    void updateLeague(LeagueEntity league, String name, int year);
    void deleteLeague(String name, int year);

}
