package com.challenge.tournament.domain;

public class DivisionStanding {
	
	private int teamId;
	
	private String teamName;
	
	private int wins;
	
	private int losses;
	
	private long winningPct;
	
	private int pointsFor;
	
	private int pointsAgainst;
	
	private int pointsDiff;
	
	
	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public long getWinningPct() {
		return winningPct;
	}

	public void setWinningPct(long winningPct) {
		this.winningPct = winningPct;
	}

	public int getPointsFor() {
		return pointsFor;
	}

	public void setPointsFor(int pointsFor) {
		this.pointsFor = pointsFor;
	}

	public int getPointsAgainst() {
		return pointsAgainst;
	}

	public void setPointsAgainst(int pointsAgainst) {
		this.pointsAgainst = pointsAgainst;
	}

	public int getPointsDiff() {
		return pointsDiff;
	}

	public void setPointsDiff(int pointsDiff) {
		this.pointsDiff = pointsDiff;
	}


}
