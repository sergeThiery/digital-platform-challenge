package com.challenge.tournament.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class LeagueRequest {

	@NotEmpty
	@Length(max = 40)
	private String name;
	
	
	private int year;
	
	private String city;
	
	public LeagueRequest(String leagueName) {
		this.name = leagueName;
	} 

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
