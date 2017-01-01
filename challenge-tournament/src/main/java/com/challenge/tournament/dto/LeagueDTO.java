package com.challenge.tournament.dto;

import java.io.Serializable;

import com.challenge.common.api.JsonDto;

public class LeagueDTO implements Serializable, JsonDto{

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
