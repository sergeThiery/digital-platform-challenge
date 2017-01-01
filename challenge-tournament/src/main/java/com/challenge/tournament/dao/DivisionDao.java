package com.challenge.tournament.dao;

import java.util.List;

import com.challenge.tournament.entity.DivisionEntity;

public interface DivisionDao {
	
	List<DivisionEntity> findAll();
    void insertDivision(DivisionEntity league);
    void updateDivision(DivisionEntity league, String name, int year);
    void deleteDivision(String leagueName, int leagueYear,
			String divisionName);

}
