package com.challenge.tournament.core.service;

import java.util.List;

import com.challenge.tournament.domain.Division;
import com.challenge.tournament.request.DivisionRequest;

public interface DivisionCoreService {
	
	List<Division> retrieveDivisions(String leagueName, int leagueYear);
	
	void addDivision(DivisionRequest divisionRequest);
	
	void deleteDivision(String leagueName, int leagueYear, String divisionName);
	
	void updateDivision(String leagueName, int leagueYear, String divisionName, DivisionRequest divisionRequest);

}
