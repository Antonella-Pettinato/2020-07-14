package it.polito.tdp.PremierLeague.model;

import java.util.List;

public class Team {
	Integer teamID;
	String name;
	List<Integer> esiti;
	int punteggio;

	public Team(Integer teamID, String name) {
		super();
		this.teamID = teamID;
		this.name = name;
	}
	
	public Team(Integer teamID, String name, List<Integer> esiti) {
		super();
		this.teamID = teamID;
		this.name = name;
		this.esiti = esiti;
		//this.punteggio = punteggio;
	}

	public Integer getTeamID() {
		return teamID;
	}
	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teamID == null) ? 0 : teamID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (teamID == null) {
			if (other.teamID != null)
				return false;
		} else if (!teamID.equals(other.teamID))
			return false;
		return true;
	}

	public List<Integer> getEsiti() {
		return esiti;
	}

	public void setEsiti(List<Integer> esiti) {
		this.esiti = esiti;
	}
	
}
