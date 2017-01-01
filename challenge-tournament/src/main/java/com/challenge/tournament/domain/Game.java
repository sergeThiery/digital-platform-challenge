package com.challenge.tournament.domain;

public class Game {
	
private int id;
	
	private String location;
	
	private String locationUrl;
	
	private int locationId;
	
	private String team1;
	
	private int team1Id;
	
	private String team2;
	
	private int team2Id;
	
	private String team1Score;
	
	private String team2Score;
	
	private String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationUrl() {
		return locationUrl;
	}

	public void setLocationUrl(String locationUrl) {
		this.locationUrl = locationUrl;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public int getTeam1Id() {
		return team1Id;
	}

	public void setTeam1Id(int team1Id) {
		this.team1Id = team1Id;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public int getTeam2Id() {
		return team2Id;
	}

	public void setTeam2Id(int team2Id) {
		this.team2Id = team2Id;
	}

	public String getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(String team1Score) {
		this.team1Score = team1Score;
	}

	public String getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(String team2Score) {
		this.team2Score = team2Score;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


}
