package com.challenge.tournament.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.challenge.common.dao.AbstractDao;
import com.challenge.tournament.entity.LeagueEntity;

public class LeagueDaoImpl extends AbstractDao<Integer, LeagueEntity> implements LeagueDao {

	/**
	 * retrieves all leagues
	 *
	 * @return List all leagues.
	 */
	@SuppressWarnings("unchecked")
	public List<LeagueEntity> findAll() {
		Query query = getSession().createSQLQuery("select * from Leagues");

		List<Object[]> tuples = (List<Object[]>) query.list();

		return transformTuplesToEntity(tuples);

	}

	private List<LeagueEntity> transformTuplesToEntity(List<Object[]> tuples) {

		List<LeagueEntity> leagueEntities = new ArrayList<LeagueEntity>();

		for (Object[] tuple : tuples) {

			LeagueEntity leagueEntity = new LeagueEntity();
			leagueEntity.setName(tuple[1].toString());

			leagueEntities.add(leagueEntity);
		}

		return leagueEntities;
	}

	/**
	 * retrieves League given an ID
	 * 
	 * @return id Id of the league
	 */
	public LeagueEntity retrieveLeagueById(int id) {
		return this.getByKey(id);
	}


	@Override
	public void insertLeague(LeagueEntity league) {
		persist(league);
		
	}

	@Override
	public void updateLeague(LeagueEntity league, String name, int year) {
		league.setName(name);
		league.setYear(year);
		getSession().saveOrUpdate(league);
		
	}

	@Override
	public void deleteLeague(String name, int year) {
		LeagueEntity leagueEntity = new LeagueEntity();
		leagueEntity.setName(name);
		leagueEntity.setYear(year);
		delete(leagueEntity);
		
	}
}
