package com.challenge.tournaments.dto;

import java.io.Serializable;

public class LeagueDTO implements Serializable{

	/**
	 * Auto Generated ID
	 */
	private static final long serialVersionUID = 2276924206327708101L;

	/**
	 * Name of the league
	 */
	private String name;
	
	/**
	 * League ID
	 */
	private int id;

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
