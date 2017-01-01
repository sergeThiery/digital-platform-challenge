package com.challenge.tournament.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.challenge.common.api.JsonDto;
import com.challenge.tournament.domain.Game;
import com.challenge.tournament.domain.League;
import com.challenge.tournament.domain.Location;
import com.challenge.tournament.domain.Standing;
import com.challenge.tournament.domain.Team;

public class LeagueDataDTO implements Serializable, JsonDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private League league;

	private List<Team> teams = new ArrayList<Team>();

	private List<Location> locations = new ArrayList<Location>();

	private List<Game> games = new ArrayList<Game>();

	private List<Standing> standings = new ArrayList<Standing>();

	public List<Standing> getStandings() {
		return standings;
	}

	public void setStandings(List<Standing> standings) {
		this.standings = standings;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

}
