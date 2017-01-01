package com.challenge.tournament.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Leagues")
public class LeagueEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2276924206327708101L;

	/**
	 * 
	 */
	@Column(name = "CITY_NAME")
	private String cityName;
	
	/**
	 * 
	 */
	@Column(name = "YEAR")
	@Id
	private int year;
	
	@Column(name = "LEAGUE_NAME")
	private String name;
	
	
	public LeagueEntity(){
		
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	


}
