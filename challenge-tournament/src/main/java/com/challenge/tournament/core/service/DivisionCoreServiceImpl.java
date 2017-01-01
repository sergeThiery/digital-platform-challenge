package com.challenge.tournament.core.service;

import java.util.List;

import javax.inject.Inject;

import com.challenge.tournament.dao.DivisionDao;
import com.challenge.tournament.domain.Division;
import com.challenge.tournament.request.DivisionRequest;

public class DivisionCoreServiceImpl implements DivisionCoreService{
	
	@Inject
	private DivisionDao divisionDao;

	@Override
	public List<Division> retrieveDivisions(String leagueName, int leagueYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDivision(DivisionRequest divisionRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDivision(String leagueName, int leagueYear,
			String divisionName) {
		divisionDao.deleteDivision(leagueName, leagueYear,divisionName);
		
	}

	@Override
	public void updateDivision(String leagueName, int leagueYear,
			String divisionName, DivisionRequest divisionRequest) {
		// TODO Auto-generated method stub
		
	}

}
