package com.challenge.tournament.core.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.challenge.tournament.dao.LeagueDao;
import com.challenge.tournament.domain.League;
import com.challenge.tournament.dto.LeagueDTO;
import com.challenge.tournament.entity.LeagueEntity;
import com.challenge.tournament.request.LeagueRequest;
import com.challenge.tournament.request.LeagueToDeleteRequest;

@Transactional
public class LeagueCoreServiceImpl implements LeagueCoreService {

	@Inject
	private LeagueDao leagueDao;

	@Override
	public List<League> retrieveLeagues() {
		List<LeagueEntity> entities = leagueDao.findAll();
		List<League> leagues = new ArrayList<>();
		for (LeagueEntity entity : entities) {
			leagues.add(transformEntityToDomain(entity));
		}
		return leagues;
	}

	@Override
	public LeagueDTO retrieveLeague(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLeagues(List<LeagueToDeleteRequest> requestList) {

		for (LeagueToDeleteRequest leagueToDeleteRequest : requestList) {
			leagueDao.deleteLeague(leagueToDeleteRequest.getName(),
					leagueToDeleteRequest.getYear());
		}

	}

	@Override
	public void updateLeague(String name, int year, LeagueRequest leagueRequest) {
		leagueDao.updateLeague(transformRequetToEntity(leagueRequest), name,
				year);

	}

	@Override
	public void addLeague(LeagueRequest leagueRequest) {
		leagueDao.insertLeague(transformRequetToEntity(leagueRequest));

	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	private League transformEntityToDomain(LeagueEntity entity) {

		League league = new League();
		league.setLeagueCity(entity.getCityName());
		league.setLeagueName(entity.getName());
		league.setLeagueYear(entity.getYear());

		return league;
	}

	/**
	 * 
	 * @param league
	 * @return
	 */
	private LeagueEntity transformRequetToEntity(LeagueRequest league) {
		LeagueEntity leagueEntity = new LeagueEntity();
		leagueEntity.setCityName(league.getCity());
		leagueEntity.setName(league.getName());
		leagueEntity.setYear(league.getYear());
		return leagueEntity;
	}

}
