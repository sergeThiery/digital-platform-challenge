package com.challenge.tournaments.domain;

import java.util.ArrayList;
import java.util.List;

public class Standing {
	
	private String divisionName;
	
	private List<DivisionStanding> divisionStandings = new ArrayList<DivisionStanding>();

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public List<DivisionStanding> getDivisionStandings() {
		return divisionStandings;
	}

	public void setDivisionStandings(List<DivisionStanding> divisionStandings) {
		this.divisionStandings = divisionStandings;
	}

}
