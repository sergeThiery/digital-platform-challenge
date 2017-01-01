package com.challenge.tournaments.domain;

import java.util.List;

public class Team {

	private String divisionName;

	private List<DivisionTeam> divisionTeams;

	public void addDivisionTeam(DivisionTeam divisionTeam) {
		divisionTeams.add(divisionTeam);
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public List<DivisionTeam> getDivisionTeams() {
		return divisionTeams;
	}

	public void setDivisionTeams(List<DivisionTeam> divisionTeams) {
		this.divisionTeams = divisionTeams;
	}

}
